package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.AluminNews;
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
 * @create 2019-03-23 16:22
 */
@Controller
@RequestMapping("/article/alumin")
public class AluminController {

    @Autowired
    private ArticleService articleService;
    // TODO 考虑全部移植到 article接口中
    /**
     * 获取校友新闻列表 未分页
     * // TODO 考虑分页实现方式
     * @return
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/news")
    public List<ArticleEntity> aluminNewsList() {
        return articleService.aluminNewsList();
    }


    /**
     * 根据ID 获取新闻 得详细信息
     * @param id , 新闻得ID
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/details")
    public ArticleEntity aluminDetails(@RequestParam("id") String id) {
        return articleService.newsDetails(id);
    }

    /**
     *  获取 校友新闻 中校友活动 得数据
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/events")
    public List<ArticleEntity> aluminEventsList() {
        return articleService.aluminEventsList();
    }

    /**
     *  搜索校友 ， 未确认
     *
     */

}
