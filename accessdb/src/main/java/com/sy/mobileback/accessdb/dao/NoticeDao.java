package com.sy.mobileback.accessdb.dao;

import com.sy.mobileback.accessdb.domain.News;
import com.sy.mobileback.accessdb.domain.NewsContent;
import com.sy.mobileback.accessdb.domain.NewsPage;
import com.sy.mobileback.common.accessdb.AccessDBOperateUtils;
import com.sy.mobileback.common.constant.AccessConstants;
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
 * @create 2019-02-26 22:07
 */
@Repository
public class NoticeDao {

    @Autowired
    private Connection accessConn;

    public List<News> selectAllNotice() {
        List<News> linkList = new ArrayList<>();
        try {
            String sql = "select * from News";
            List<Object> paramList = new ArrayList<>();
            List<Map<String, Object>> list = AccessDBOperateUtils.select(accessConn, sql, paramList);
            for (Map<String, Object> mapInfo : list) {
                News news = new News();
                for (Map.Entry<String, Object> entry : mapInfo.entrySet()) {
                    ReflectUtils.invokeSetter(news, entry.getKey(), entry.getValue());
                }
                linkList.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linkList;
    }

    /**
     * 按分页返回 新闻的ID，标题，日期 信息
     * @param pageNum
     * @return
     */
    public List<NewsPage> selectNoticePageByPage(int pageNum) {
        // 已经读取的数据 如果为0 ， 则代表 第一页
        int readedCount = AccessConstants.PAGE_SIZE*(pageNum-1);
        String sql;
        if (readedCount ==0) {
            sql = "SELECT  top " + AccessConstants.PAGE_SIZE + " N_Id , N_Title , N_Date from News where N_Comstye = 126 order by N_Id";
        } else {
            sql ="SELECT  top " + AccessConstants.PAGE_SIZE + " N_Id , N_Title , N_Date from News where N_Comstye = 126 and  (N_Id > (select MAX(N_Id) from ( select top "+ readedCount +" N_Id from News where N_Comstye = 126  order by N_Id) as T)) order by N_Id ";
        }
        List<NewsPage> linkList = new ArrayList<>();
        try {
            List<Object> paramList = new ArrayList<>();
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

    public List<News> selectNoticeByPage(int pageNum) {
        // 已经读取的数据 如果为0 ， 则代表 第一页
        int readedCount = AccessConstants.PAGE_SIZE*(pageNum-1);
        String sql;
        if (readedCount ==0) {
            sql = "SELECT  top " + AccessConstants.PAGE_SIZE + " * from where N_Comstye = 126 News order by N_Id";
        } else {
            sql ="SELECT  top " + AccessConstants.PAGE_SIZE + " * from News where N_Comstye = 126 and (N_Id > (select MAX(N_Id) from ( select top "+ readedCount +" N_Id from News order by N_Id) as T)) order by N_Id ";
        }
        List<News> linkList = new ArrayList<>();
        try {
            List<Object> paramList = new ArrayList<>();
            List<Map<String, Object>> list = AccessDBOperateUtils.select(accessConn, sql, paramList);
            if (null!=list && list.size()>0) {
                for (Map<String, Object> mapInfo : list) {
                    News news = new News();
                    for (Map.Entry<String, Object> entry : mapInfo.entrySet()) {
                        ReflectUtils.invokeSetter(news, entry.getKey(), entry.getValue());
                    }
                    linkList.add(news);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linkList;
    }


    /**
     * 根据ID 返回新闻的详细信息
     * @param id
     * @return
     */
    public NewsContent selectNoticeById(String id) {
        NewsContent newsContent = new NewsContent();
        try {
            String sql = "select N_Id , N_Content from News where N_Id = ? and N_Comstye = 126";
            List<Object> paramList = new ArrayList<>();
            paramList.add(id);
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
