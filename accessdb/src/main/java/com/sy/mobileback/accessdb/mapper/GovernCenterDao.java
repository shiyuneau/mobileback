package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.GoverCenterEntity;
import com.sy.mobileback.accessdb.domain.NewsContent;
import com.sy.mobileback.accessdb.domain.NewsPage;
import com.sy.mobileback.common.accessdb.AccessDBOperateUtils;
import com.sy.mobileback.common.reflect.ReflectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author shiyu
 * @Description
 * @create 2019-03-19 19:03
 */
@Repository
public class GovernCenterDao {
    @Autowired
    private Connection accessConn;

    /**
     * 获取所有得栏目 列表
     * @return
     */
    public List<GoverCenterEntity> goverCenterList() {
        List<GoverCenterEntity> entityList = new ArrayList<>();
        String sql = "select Com_Id , Com_Fid , Com_Stye from Comstye";
        try {
            List<Object> paramList = new ArrayList<>();
            List<Map<String, Object>> list = AccessDBOperateUtils.select(accessConn, sql, paramList);
            if (null != list && list.size() > 0) {
                for (Map<String, Object> mapInfo : list) {
                    GoverCenterEntity entity = new GoverCenterEntity();
                    for (Map.Entry<String, Object> entry : mapInfo.entrySet()) {
                        ReflectUtils.invokeSetter(entity, entry.getKey(), entry.getValue());
                    }
                    entityList.add(entity);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return entityList;
    }

    /**
     * 根据指定得栏目ID， 获取 该栏目下得所有列表
     * @param governId
     * @return
     */
    public List<NewsPage> governNewsList(String governId) {
       String sql = "select N_Id , N_Title , N_Date from News where N_Comstye = ? order by N_Id";
        List<NewsPage> linkList = new ArrayList<>();
        try {
            List<Object> paramList = new ArrayList<>();
            paramList.add(governId);
            List<Map<String, Object>> list = AccessDBOperateUtils.select(accessConn, sql, paramList);
            if (null!=list && list.size()>0) {
                for (Map<String, Object> mapInfo : list) {
                    NewsPage news = new NewsPage();
                    for (Map.Entry<String, Object> entry : mapInfo.entrySet()) {
                        ReflectUtils.invokeSetter(news, entry.getKey(), entry.getValue());
                    }
                    // 设置时间的格式
                    String[] dateArr = news.getN_Date().split(" ");
                    news.setN_Date(dateArr[0]);
                    linkList.add(news);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linkList;
    }

    /**
     * 根据指定新闻ID获取 新闻得详细信息
     * @param newsId
     * @return
     */
    public NewsContent governNewsDetails(String newsId) {
        NewsContent newsContent = new NewsContent();
        try {
            String sql = "select N_Id , N_Title, N_Content from News where N_Id = ?";
            List<Object> paramList = new ArrayList<>();
            paramList.add(newsId);
            List<Map<String, Object>> list = AccessDBOperateUtils.select(accessConn, sql, paramList);
            for (Map<String, Object> mapInfo : list) {
                for (Map.Entry<String, Object> entry : mapInfo.entrySet()) {
                    ReflectUtils.invokeSetter(newsContent, entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsContent;
    }
}
