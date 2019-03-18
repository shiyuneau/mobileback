package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.dao.NoticeDao;
import com.sy.mobileback.accessdb.domain.NewsContent;
import com.sy.mobileback.accessdb.domain.NewsPage;
import com.sy.mobileback.accessdb.service.NoticeService;
import com.sy.mobileback.common.page.TableDataInfo;
import com.sy.mobileback.framework.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-03-18 21:35
 */
@RestController()
@RequestMapping("/notice")
public class AccessNoticeController extends BaseController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping(value = "/listPage")
    @ResponseBody
    public TableDataInfo newspageByParams(@RequestParam("pageNum") int pageNum) {
        List<NewsPage> newsList = noticeService.selectNoticePageByPage(pageNum);
        return getDataTable(newsList);
    }

    @GetMapping(value = "/searchId/{id}")
    @ResponseBody
    public NewsContent selectNewsById(@PathVariable("id") String id) {
        return noticeService.selectNoticeContentByID(id);
    }
}
