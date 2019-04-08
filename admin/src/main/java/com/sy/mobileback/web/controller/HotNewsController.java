package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.ArticleEntity;
import com.sy.mobileback.accessdb.service.ArticleService;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-03-23 17:04
 */
@Controller
@RequestMapping("/article/hotnews")
public class HotNewsController {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取 热点新闻数据
     * @return
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/list")
    public List<ArticleEntity> hotNewsList() {
        return articleService.hotNewsList();
    }

    /**
     * 根据 热点新闻的详细 数据
     * @param id , 热点新闻ID
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/details")
    public ArticleEntity hotnewsDetails(@RequestParam("id") String id) {
        return articleService.newsDetails(id);
    }

    /**
     * 新闻热点文章搜索（搜索类型 校友或文章）
//     * @param type 搜索类型 1 校友 ，2 文章
     * @param content 搜索内容
     * @return
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/hotnewsSearch")
    // @RequestParam("type") String type ,
    public List<ArticleEntity> hotnewsSearch( @RequestParam("content") String content) {
        return articleService.hotnewSearch(content);
    }

}
