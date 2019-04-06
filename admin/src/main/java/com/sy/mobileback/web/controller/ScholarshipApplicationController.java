package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.ScholarshipapplicationEntity;
//import com.sy.mobileback.accessdb.service.ScholarshipApplicationService;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

/**
 * 奖学金
 * @auther ShiYan.Shi
 * @create 2019/4/5   23:45
 */
@Controller
@RequestMapping("/scholarship")
public class ScholarshipApplicationController {
//    @Autowired
//    private ScholarshipApplicationService scholarshipApplicationService;

    /**
     * 奖学金申请
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/apply")
    public String scholarshipApply(@RequestBody Map<String,Object> apply, HttpServletRequest request) {
        if(apply.isEmpty()){
            return "-1";
        }
        //生成guid
        String guid = UUID.randomUUID().toString();
        ScholarshipapplicationEntity entity = new ScholarshipapplicationEntity();

        return null;
    }
}
