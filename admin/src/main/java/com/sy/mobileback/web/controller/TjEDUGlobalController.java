package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.Comstye;
import com.sy.mobileback.accessdb.domain.NewsContent;
import com.sy.mobileback.accessdb.domain.NewsPage;
import com.sy.mobileback.accessdb.service.TjEDUGlobaService;
import com.sy.mobileback.common.page.TableDataInfo;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import com.sy.mobileback.framework.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shiyu
 * @Description 天津教育国籍交流所有页面
 * @create 2019-05-09 12:26
 */
@Controller
@RequestMapping("/tjdeuglobal")
public class TjEDUGlobalController extends BaseController {

    @Autowired
    private TjEDUGlobaService tjEDUGlobaService;




    /**
     * 办事流程 子菜单
     * @return
     */
    @RequestMapping("/bslc/list")
    @JwtIgnore
    @ResponseBody
    public List<Comstye> bslcList(){
        return tjEDUGlobaService.bslxList();
    }

    /**
     * 办事流程 单个 子菜单  的 文章 简略信息
     * @param pageNum
     * @param id
     * @return
     */
    @JwtIgnore
    @GetMapping(value = "/bslc/listPage")
    @ResponseBody
    public TableDataInfo newspageByParams(@RequestParam("pageNum") int pageNum , @RequestParam("id") String id) {
        List<NewsPage> newsList = tjEDUGlobaService.selectBslcListByPage(pageNum,id);
        return getDataTable(newsList);
    }

    /**
     * 办事流程  文章 信息
     * @param id
     * @return
     */
    @JwtIgnore
    @GetMapping(value = "/bslc/searchId/{id}")
    @ResponseBody
    public NewsContent selectNewsById(@PathVariable("id") String id) {
        return tjEDUGlobaService.selectNewsById(id);
    }


}
