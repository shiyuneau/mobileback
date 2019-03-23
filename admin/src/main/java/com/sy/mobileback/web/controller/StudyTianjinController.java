package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.ArticleEntity;
import com.sy.mobileback.accessdb.service.ArticleService;
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
@RequestMapping("/article/studytianjin")
public class StudyTianjinController {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取为什么留学天津 新闻列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/news")
    public List<ArticleEntity> studytianjinNewsList() {
        return articleService.studytianjinNewsList();
    }

    /**
     * 根据ID 获取 新闻详细信息
     * @param id , 栏目得ID
     */
    @ResponseBody
    @RequestMapping("/details")
    public ArticleEntity overseaslifeDetails(@RequestParam("id") String id) {
        return articleService.newsDetails(id);
    }
}
