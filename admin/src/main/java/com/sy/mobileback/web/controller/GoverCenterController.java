package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.GoverCenterEntity;
import com.sy.mobileback.accessdb.domain.NewsContent;
import com.sy.mobileback.accessdb.domain.NewsPage;
import com.sy.mobileback.accessdb.service.GoverCenterService;
import com.sy.mobileback.common.utils.StringUtils;
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
 * @create 2019-03-19 19:15
 */
@Controller
@RequestMapping("/govern")
public class GoverCenterController {

    @Autowired
    private GoverCenterService goverCenterService;

    /**
     * 政务中心列表，树级显示
     * @return
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/list")
    public GoverCenterEntity governCenterList(){
        return goverCenterService.goverCenterList();
    }

    /**
     * 获取指定栏目 下得 新闻列表， 能获取到得 新闻列表 得栏目肯定是 最后一级 得栏目
     * @return
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/news")
    public List<NewsPage> governNewsList(@RequestParam("governId") String governId) {
        if (null!=governId && StringUtils.isNotEmpty(governId)) {
            return goverCenterService.governNewsList(governId);
        }
        return null;
    }

    @JwtIgnore
    @ResponseBody
    @RequestMapping("/details")
    public NewsContent governNewsContent(@RequestParam("newsId") String newsId) {
        if (null!=newsId && StringUtils.isNotEmpty(newsId)) {
            return goverCenterService.governNewsDetail(newsId);
        }
        return null;
    }
}
