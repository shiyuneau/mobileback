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
	
}
