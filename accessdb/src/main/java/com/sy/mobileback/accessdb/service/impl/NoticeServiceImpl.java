package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.dao.NewsDao;
import com.sy.mobileback.accessdb.dao.NoticeDao;
import com.sy.mobileback.accessdb.domain.News;
import com.sy.mobileback.accessdb.domain.NewsContent;
import com.sy.mobileback.accessdb.domain.NewsPage;
import com.sy.mobileback.accessdb.service.NewsService;
import com.sy.mobileback.accessdb.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-02-26 22:12
 */

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<NewsPage> selectNoticePageByPage(int pageNum) {
        return noticeDao.selectNoticePageByPage(pageNum);
    }

    @Override
    public NewsContent selectNoticeContentByID(String id) {
        return noticeDao.selectNoticeById(id);
    }
}
