package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.ArticleEntity;
import com.sy.mobileback.accessdb.service.ArticleService;
import com.sy.mobileback.common.constant.AccessConstants;
import com.sy.mobileback.common.utils.JsonResult;
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
@RequestMapping("/article/studytianjin")
public class StudyTianjinController {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取为什么留学天津 新闻列表
     * @return
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/news")
    public JsonResult studytianjinNewsList(@RequestParam(value = "pageNum",required = false) Integer pageNum, @RequestParam(value = "pageSize",required = false) Integer pageSize) {
        // 如果pagNum和pageSize都不传，只查前十页
        if (null==pageNum ) {
            pageNum=1;
        }
        if (null==pageSize) {
            pageSize = AccessConstants.PAGE_SIZE;
        }
        return articleService.studytianjinNewsList(pageNum,pageSize);
    }

    /**
     * 根据ID 获取 新闻详细信息
     * @param id , 栏目得ID
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/details")
    public ArticleEntity overseaslifeDetails(@RequestParam("id") String id) {
        return articleService.newsDetails(id);
    }
}
