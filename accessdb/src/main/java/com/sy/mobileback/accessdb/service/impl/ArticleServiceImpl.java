package com.sy.mobileback.accessdb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sy.mobileback.accessdb.mapper.ArticleDao;
import com.sy.mobileback.accessdb.domain.ArticleEntity;
import com.sy.mobileback.accessdb.service.ArticleService;


@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    /**
     * 获取校友新闻列表
     * @return
     */
    @Override
    public List<ArticleEntity> aluminNewsList() {
        return articleDao.aluminNewsList();
    }

    @Override
    public ArticleEntity newsDetails(String id) {
        return articleDao.newsDetails(id);
    }

    @Override
    public List<ArticleEntity> aluminEventsList() {
        return articleDao.aluminEventsList();
    }

    @Override
    public List<ArticleEntity> lifeAssistantNewsList() {
        return articleDao.lifeAssistantNewsList();
    }

    @Override
    public List<ArticleEntity> overseaslifeNewsList() {
        return articleDao.overseasNewsList();
    }

    @Override
    public List<ArticleEntity> studytianjinNewsList() {
        return articleDao.studytianjinNewsList();
    }

    @Override
    public List<ArticleEntity> hotNewsList() {
        return articleDao.hotNewsList();
    }

    @Override
    public List<ArticleEntity> experienceTJNewsList() {
        return articleDao.experienceTJNewsList();
    }

    @Override
    public List<ArticleEntity> hotnewSearch(String content) {
        return articleDao.hotnewSearch(content);
    }
}
