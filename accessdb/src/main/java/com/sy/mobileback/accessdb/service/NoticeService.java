package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.NewsContent;
import com.sy.mobileback.accessdb.domain.NewsPage;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-03-18 21:32
 */
public interface NoticeService {
    public List<NewsPage> selectNoticePageByPage(int pageNum);

    NewsContent selectNoticeContentByID(String id);
}
