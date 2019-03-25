package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.GoverCenterEntity;
import com.sy.mobileback.accessdb.service.GoverCenterService;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @JwtIgnore
    @ResponseBody
    @RequestMapping("/list")
    public GoverCenterEntity governCenterList(){
        return goverCenterService.goverCenterList();
    }
}
