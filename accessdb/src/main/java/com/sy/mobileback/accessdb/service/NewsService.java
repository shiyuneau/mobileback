package com.sy.mobileback.accessdb.service;

import com.sy.mobileback.accessdb.domain.News;
import com.sy.mobileback.accessdb.domain.NewsContent;
import com.sy.mobileback.accessdb.domain.NewsPage;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-02-26 22:11
 */
public interface NewsService {
    /**
     * 返回所有的文章
     * @return
     */
    // TODO 考虑分页返回
    List<News> selectAllNews();

    List<News> selectNewsByPage(int pageNum);

    /**
     * 根据id查询新闻
     * @param id 文章ID
     * @return
     */
    NewsContent selectNewsById(String id);


    /**
     *  返回新闻中指定的字段
     * @param pageNum 页数
     * @return
     */
    List<NewsPage> selectNewsPageByPage(int pageNum);
}
