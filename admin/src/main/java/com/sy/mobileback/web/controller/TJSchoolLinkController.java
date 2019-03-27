package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.LinkEntity;
import com.sy.mobileback.accessdb.service.LinkService;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-03-27 21:02
 */
@Controller
@RequestMapping("/tjschools")
public class TJSchoolLinkController {
    @Autowired
    private LinkService linkService;


    /**
     * 获取 天津市 各 高校网站
     * @return
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/links")
    public List<LinkEntity> links() {
        return linkService.links();
    }
}
