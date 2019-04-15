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
 * @create 2019-03-26 18:26
 */
@Controller
@RequestMapping("/article/exeperienceTJ")
public class ExeperienceTJController {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取 体验天津得 新闻接口
     * @return
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/news")
    public JsonResult experienceTJNewsList(@RequestParam(value = "pageNum",required = false) Integer pageNum, @RequestParam(value = "pageSize",required = false) Integer pageSize) {
        // 如果pagNum和pageSize都不传，只查前十页
        if (null==pageNum ) {
            pageNum=1;
        }
        if (null==pageSize) {
            pageSize = AccessConstants.PAGE_SIZE;
        }
        return articleService.experienceTJNewsList(pageNum,pageSize);
    }

    /**
     * 根据新闻ID 获取 具体得新闻信息
     * @param id , 新闻ID
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/details")
    public ArticleEntity newsDetails(@RequestParam("id") String id) {
        return articleService.newsDetails(id);
    }

}
