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
 * @create 2019-03-23 17:04
 */
@Controller
@RequestMapping("/article/lifeassistant")
public class LifeAssistantController {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取生活助手子栏目
     * @return
     */
    @ResponseBody
    @RequestMapping("/news")
    public List<ArticleEntity> lifeAssistantNewsList() {
        return articleService.lifeAssistantNewsList();
    }

    /**
     * 根据ID栏目详细
     * @param id , 栏目得ID
     */
    @ResponseBody
    @RequestMapping("/details")
    public ArticleEntity aluminDetails(@RequestParam("id") String id) {
        return articleService.newsDetails(id);
    }

}
