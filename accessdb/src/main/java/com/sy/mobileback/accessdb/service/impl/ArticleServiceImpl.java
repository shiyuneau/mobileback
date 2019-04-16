package com.sy.mobileback.accessdb.service.impl;

import com.sy.mobileback.common.constant.AccessConstants;
import com.sy.mobileback.common.page.PageUtils;
import com.sy.mobileback.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sy.mobileback.accessdb.mapper.ArticleDao;
import com.sy.mobileback.accessdb.domain.ArticleEntity;
import com.sy.mobileback.accessdb.service.ArticleService;


@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    /**
     * 获取校友新闻列表
     *
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
    public JsonResult aluminEventsList(int pageNum, int pageSize) {
        // pageNum 第一页肯定是1 ，但limit 是从 0-10
        try {
            int total = articleDao.aluminEventsCount();
            Map<String, Integer> pageMap = PageUtils.pageCreate(pageNum, pageSize);
            List<ArticleEntity> list = articleDao.aluminEventsListByPage(pageMap);
            return PageUtils.resultCreate(list, total);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.error();
    }

    @Override
    public JsonResult aluminNewsList(int pageNum, int pageSize) {
        // pageNum 第一页肯定是1 ，但limit 是从 0-10
        try {
            int total = articleDao.aluminNewsCount();
            Map<String, Integer> pageMap = PageUtils.pageCreate(pageNum, pageSize);
            List<ArticleEntity> list = articleDao.aluminEventsListByPage(pageMap);
            return PageUtils.resultCreate(list, total);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.error();

    }

    @Override
    public List<ArticleEntity> lifeAssistantNewsList() {
        return articleDao.lifeAssistantNewsList();
    }

    @Override
    public JsonResult lifeAssistantNewsList(int pageNum, int pageSize) {
        // pageNum 第一页肯定是1 ，但limit 是从 0-10
        try {
            int total = articleDao.lifeAssistantNewsCount();
            Map<String, Integer> pageMap = PageUtils.pageCreate(pageNum, pageSize);
            List<ArticleEntity> list = articleDao.lifeAssistantNewsListByPage(pageMap);
            return PageUtils.resultCreate(list, total);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.error();

    }

    @Override
    public List<ArticleEntity> overseaslifeNewsList() {
        return articleDao.overseasNewsList();
    }

    @Override
    public JsonResult overseaslifeNewsList(int pageNum, int pageSize) {
        // pageNum 第一页肯定是1 ，但limit 是从 0-10
        try {
            int total = articleDao.overseasNewsCount();
            Map<String, Integer> pageMap = PageUtils.pageCreate(pageNum, pageSize);
            List<ArticleEntity> list = articleDao.overseasNewsListByPage(pageMap);
            return PageUtils.resultCreate(list, total);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.error();

    }

    @Override
    public List<ArticleEntity> studytianjinNewsList() {
        return articleDao.studytianjinNewsList();
    }

    @Override
    public JsonResult studytianjinNewsList(int pageNum, int pageSize) {
        // pageNum 第一页肯定是1 ，但limit 是从 0-10
        try {
            int total = articleDao.studytianjinNewsCount();
            Map<String, Integer> pageMap = PageUtils.pageCreate(pageNum, pageSize);
            List<ArticleEntity> list = articleDao.studytianjinNewsListByPage(pageMap);
            return PageUtils.resultCreate(list, total);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.error();

    }

    @Override
    public List<ArticleEntity> hotNewsList() {
        return articleDao.hotNewsList();
    }

    @Override
    public JsonResult hotNewsList(int pageNum, int pageSize) {
        // pageNum 第一页肯定是1 ，但limit 是从 0-10
        try {
            int total = articleDao.hotNewsCount();
            Map<String, Integer> pageMap = PageUtils.pageCreate(pageNum, pageSize);
            List<ArticleEntity> list = articleDao.hotNewsListByPage(pageMap);
            return PageUtils.resultCreate(list, total);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.error();

    }

    @Override
    public List<ArticleEntity> experienceTJNewsList() {
        return articleDao.experienceTJNewsList();
    }

    @Override
    public JsonResult experienceTJNewsList(int pageNum, int pageSize) {
        // pageNum 第一页肯定是1 ，但limit 是从 0-10
        try {
            int total = articleDao.experienceTJNewsCount();
            Map<String, Integer> pageMap = PageUtils.pageCreate(pageNum, pageSize);
            List<ArticleEntity> list = articleDao.experienceTJNewsListByPage(pageMap);
            return PageUtils.resultCreate(list, total);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.error();

    }

    @Override
    public List<ArticleEntity> hotnewSearch(String content) {
        return articleDao.hotnewSearch(content);
    }

    @Override
    public JsonResult hotnewSearch(String content, int pageNum, int pageSize) {
        // pageNum 第一页肯定是1 ，但limit 是从 0-10
        return null;
    }
}
