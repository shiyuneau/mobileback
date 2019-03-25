package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.ArticleEntity;

import java.util.List;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-23 16:06:21
 */
public interface ArticleService  {
    /**
     * 获取 留学生活 中 校友新闻得数据
     * @return
     */
    List<ArticleEntity> aluminNewsList();

    /**
     * 根据 GUID ，获取 article中文章得具体信息
     * @param id
     * @return
     */
    ArticleEntity newsDetails(String id);

    /**
     * 获取 留学生活 中 校友新闻 得数据 ，不过 数据 和 热点新闻接口得一致 ？？
     * @return
     */
    List<ArticleEntity> aluminEventsList();

    /**
     * 获取 生活助手子栏目 信息
     */
    List<ArticleEntity> lifeAssistantNewsList();

    /**
     * 获取 留学生活 栏目下面得文章 后续考虑分页
     * @return
     */
    List<ArticleEntity> overseaslifeNewsList();

    /**
     * 获取为什么留学天津文章列表
     * @return
     */
    List<ArticleEntity> studytianjinNewsList();

    /**
     * 获取 热点新闻数据
     */
    List<ArticleEntity> hotNewsList();
}

