package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.ArticleEntity;
import com.sy.mobileback.common.utils.JsonResult;

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
    JsonResult aluminNewsList(int pageNum, int pageSize);

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
    JsonResult aluminEventsList(int pageNum, int pageSize);

    /**
     * 获取 生活助手子栏目 信息
     */
    List<ArticleEntity> lifeAssistantNewsList();
    JsonResult lifeAssistantNewsList(int pageNum, int pageSize);

    /**
     * 获取 留学生活 栏目下面得文章 后续考虑分页
     * @return
     */
    List<ArticleEntity> overseaslifeNewsList();
    JsonResult overseaslifeNewsList(int pageNum, int pageSize);

    /**
     * 获取为什么留学天津文章列表
     * @return
     */
    List<ArticleEntity> studytianjinNewsList();
    JsonResult studytianjinNewsList(int pageNum, int pageSize);

    /**
     * 获取 热点新闻数据
     */
    List<ArticleEntity> hotNewsList();
    JsonResult hotNewsList(int pageNum, int pageSize);

    /**
     * 获取 体验天津 数据
     */
    List<ArticleEntity> experienceTJNewsList();
    JsonResult experienceTJNewsList(int pageNum, int pageSize);

    /**
     * 根据 搜索条件对 title进行模糊搜索
     * @return
     */
    List<ArticleEntity> hotnewSearch(String content);
    JsonResult hotnewSearch(String content,int pageNum, int pageSize);
}

