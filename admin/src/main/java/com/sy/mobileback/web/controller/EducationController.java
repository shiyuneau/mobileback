package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.service.EducationService;
import com.sy.mobileback.common.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-28 13:41
 */
@Controller
@RequestMapping("/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @RequestMapping("/list")
    @ResponseBody
    public JsonResult educationList() {
        return educationService.educationList();
    }

}
