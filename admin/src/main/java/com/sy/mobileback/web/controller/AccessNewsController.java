package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.News;
import com.sy.mobileback.accessdb.domain.NewsContent;
import com.sy.mobileback.accessdb.domain.NewsPage;
import com.sy.mobileback.accessdb.service.NewsService;
import com.sy.mobileback.common.annotation.DataSource;
import com.sy.mobileback.common.enums.DataSourceType;
import com.sy.mobileback.common.page.TableDataInfo;
import com.sy.mobileback.framework.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author shiyu
 * @Description
 * @create 2019-02-25 12:55
 */
@Controller
@RequestMapping("/news")
public class AccessNewsController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(AccessNewsController.class);


    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/all")
    @ResponseBody
    @DataSource(value = DataSourceType.SLAVE)
    public TableDataInfo accessTest() {
        List<News> newsList = newsService.selectAllNews();
        return getDataTable(newsList);
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public TableDataInfo newsByParams(@RequestParam("pageNum") int pageNum) {
        List<News> newsList = newsService.selectNewsByPage(pageNum);
        return getDataTable(newsList);
    }

    @GetMapping(value = "/listPage")
    @ResponseBody
    public TableDataInfo newspageByParams(@RequestParam("pageNum") int pageNum) {
        List<NewsPage> newsList = newsService.selectNewsPageByPage(pageNum);
        return getDataTable(newsList);
    }

    @GetMapping(value = "/searchId/{id}")
    @ResponseBody
    public NewsContent selectNewsById(@PathVariable("id") String id) {
        return newsService.selectNewsById(id);
    }

}
