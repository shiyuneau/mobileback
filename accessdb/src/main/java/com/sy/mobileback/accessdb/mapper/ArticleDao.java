package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.ArticleEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-23 16:06:21
 */
public interface ArticleDao {

    List<ArticleEntity> aluminNewsList();

    List<ArticleEntity> aluminNewsListByPage(Map<String,Integer> map);

    ArticleEntity newsDetails(String id);

    List<ArticleEntity> aluminEventsList();

    List<ArticleEntity> aluminEventsListByPage(Map<String,Integer> map);

    List<ArticleEntity> lifeAssistantNewsList();

    List<ArticleEntity> lifeAssistantNewsListByPage(Map<String,Integer> map);

    List<ArticleEntity> overseasNewsList();

    List<ArticleEntity> overseasNewsListByPage(Map<String,Integer> map);

    List<ArticleEntity> studytianjinNewsList();

    List<ArticleEntity> studytianjinNewsListByPage(Map<String,Integer> map);

    List<ArticleEntity> hotNewsList();

    List<ArticleEntity> hotNewsListByPage(Map<String,Integer> map);

    List<ArticleEntity> experienceTJNewsList();

    List<ArticleEntity> experienceTJNewsListByPage(Map<String,Integer> map);

    /**
     * 根据content 对 title进行模糊搜索
     * @param content
     * @return
     */
    List<ArticleEntity> hotnewSearch(String content);

    Integer aluminNewsCount();

    Integer aluminEventsCount();

    Integer lifeAssistantNewsCount();

    Integer overseasNewsCount();

    Integer studytianjinNewsCount();

    Integer experienceTJNewsCount();

    Integer hotNewsCount();

}
