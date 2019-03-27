package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.GoverCenterEntity;
import com.sy.mobileback.accessdb.domain.NewsContent;
import com.sy.mobileback.accessdb.domain.NewsPage;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-03-19 19:12
 */
public interface GoverCenterService {
    GoverCenterEntity goverCenterList();

    List<NewsPage> governNewsList(String governId);

    /**
     * 获取指定 新闻ID 得新闻信息
     * @param newsId
     * @return
     */
    NewsContent governNewsDetail(String newsId);
}
