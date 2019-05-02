package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.AluminNews;
import com.sy.mobileback.accessdb.domain.ArticleEntity;
import com.sy.mobileback.accessdb.service.ArticleService;
import com.sy.mobileback.common.annotation.Log;
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
 * @create 2019-03-23 16:22
 */
@Controller
@RequestMapping("/article/alumin")
public class AluminController {

    @Autowired
    private ArticleService articleService;
    // TODO 考虑全部移植到 article接口中
    /**
     * 获取校友新闻列表
     * @return
     */
    @Log
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/news")
    public JsonResult aluminNewsList(@RequestParam(value = "pageNum",required = false) Integer pageNum, @RequestParam(value = "pageSize",required = false) Integer pageSize) {
        // 如果pagNum和pageSize都不传，只查前十页
        if (null==pageNum ) {
            pageNum=1;
        }
        if (null==pageSize) {
            pageSize = AccessConstants.PAGE_SIZE;
        }
        return articleService.aluminNewsList(pageNum,pageSize);
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
    public JsonResult aluminEventsList(@RequestParam(value = "pageNum",required = false) Integer pageNum, @RequestParam(value = "pageSize",required = false) Integer pageSize) {
        // 如果pagNum和pageSize都不传，只查前十页
        if (null==pageNum ) {
            pageNum=1;
        }
        if (null==pageSize) {
            pageSize = AccessConstants.PAGE_SIZE;
        }
        return articleService.aluminEventsList(pageNum,pageSize);
    }

    /**
     *  搜索校友 ， 未确认
     *
     */

}
