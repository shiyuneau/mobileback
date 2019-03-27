package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.NewsContent;
import com.sy.mobileback.accessdb.domain.NewsPage;
import com.sy.mobileback.accessdb.mapper.GovernCenterDao;
import com.sy.mobileback.accessdb.domain.GoverCenterEntity;
import com.sy.mobileback.accessdb.service.GoverCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-03-19 19:13
 */
@Service
public class GoverCenterServiceImpl implements GoverCenterService {

    @Autowired
    private GovernCenterDao governCenterDao;

    @Override
    public GoverCenterEntity goverCenterList() {
        List<GoverCenterEntity> entityList = governCenterDao.goverCenterList();
        GoverCenterEntity rootEntity = null;
        Collections.sort(entityList, order());
        for(GoverCenterEntity entity: entityList) {
            if (entity.getCom_Stye().equals("政务公开")) {
                rootEntity = entity;
                break;
            }
        }
        if (null!=rootEntity) {
            List<GoverCenterEntity> childList = getChild(rootEntity.getCom_Id(), entityList);
            rootEntity.setChildren(childList);
            System.out.println(entityList.size());
        }
        return rootEntity;
    }

    /**
     * 获取指定栏目ID 下得所有得新闻
     * @param governId
     * @return
     */
    @Override
    public List<NewsPage>  governNewsList(String governId) {
        return governCenterDao.governNewsList(governId);
    }

    @Override
    public NewsContent governNewsDetail(String newsId) {
        return governCenterDao.governNewsDetails(newsId);
    }

    /**
     * 根据 父ID 和 所有得 栏目，构建出父ID下得所有孩子节点
     * @param id 父ID
     * @param entityList 要遍历 得 栏目 列表
     * @return
     */
    public List<GoverCenterEntity> getChild(Integer id , List<GoverCenterEntity> entityList) {
        // 子菜单
        List<GoverCenterEntity> childList = new ArrayList<>();
        for(GoverCenterEntity entity : entityList) {
            // 遍历所有节点，如果菜单的父节点 喝根节点的id 相等，该节点就是父节点的子节点
            if (entity.getCom_Fid().equals(id)) {
                childList.add(entity);
            }
        }

        // 递归遍历 子菜单，为子菜单添加 孩子节点
        for (GoverCenterEntity entity : childList) {
            entity.setChildren(getChild(entity.getCom_Id(),entityList));
        }

        if(childList.size()==0) {
            return new ArrayList<>();
        }
        return childList;
    }

    /*
     * 排序,根据order排序
     */
    public Comparator<GoverCenterEntity> order(){
        Comparator<GoverCenterEntity> comparator = new Comparator<GoverCenterEntity>() {
            @Override
            public int compare(GoverCenterEntity o1, GoverCenterEntity o2) {
                if(!(o1.getCom_Id().equals(o2.getCom_Id()))){
                    return o1.getCom_Id() - o2.getCom_Id();
                }
                return 0;
            }
        };
        return comparator;
    }
}
