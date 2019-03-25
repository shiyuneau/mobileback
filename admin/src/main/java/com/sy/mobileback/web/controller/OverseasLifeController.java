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
 * @create 2019-03-23 17:28
 */
@Controller
@RequestMapping("/article/overseaslife")
public class OverseasLifeController {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取获取留学生活 文章列表
     * @return
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/news")
    public List<ArticleEntity> overseaslifeNewsList() {
        return articleService.overseaslifeNewsList();
    }

    /**
     * 根据ID 获取新闻详细
     * @param id , 栏目得ID
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/details")
    public ArticleEntity overseaslifeDetails(@RequestParam("id") String id) {
        return articleService.newsDetails(id);
    }
}
