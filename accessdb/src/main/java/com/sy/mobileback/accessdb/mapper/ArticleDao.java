package com.sy.mobileback.accessdb.mapper;

import com.sy.mobileback.accessdb.domain.ArticleEntity;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-23 16:06:21
 */
public interface ArticleDao {

    List<ArticleEntity> aluminNewsList();

    ArticleEntity newsDetails(String id);

    List<ArticleEntity> aluminEventsList();

    List<ArticleEntity> lifeAssistantNewsList();

    List<ArticleEntity> overseasNewsList();

    List<ArticleEntity> studytianjinNewsList();

    List<ArticleEntity> hotNewsList();

    List<ArticleEntity> experienceTJNewsList();

    /**
     * 根据content 对 title进行模糊搜索
     * @param content
     * @return
     */
    List<ArticleEntity> hotnewSearch(String content);

}
