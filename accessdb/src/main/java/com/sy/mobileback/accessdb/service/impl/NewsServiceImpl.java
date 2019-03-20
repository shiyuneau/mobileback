package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.accessdb.domain.News;
import com.sy.mobileback.accessdb.mapper.NewsDao;
import com.sy.mobileback.accessdb.domain.NewsContent;
import com.sy.mobileback.accessdb.domain.NewsPage;
import com.sy.mobileback.accessdb.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-02-26 22:12
 */

@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> selectAllNews() {
        return newsDao.selectAllNews();
    }

    @Override
    public List<News> selectNewsByPage(int pageNum) {
        return newsDao.selectNewsByPage(pageNum);
    }

    @Override
    public NewsContent selectNewsById(String id) {
        return newsDao.selectNewsById(id);
    }

    @Override
    public List<NewsPage> selectNewsPageByPage(int pageNum) {
        return newsDao.selectNewsPageByPage(pageNum);
    }
}
