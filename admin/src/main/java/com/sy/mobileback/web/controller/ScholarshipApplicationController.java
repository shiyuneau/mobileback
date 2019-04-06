package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.ScholarshipapplicationEntity;
import com.sy.mobileback.accessdb.service.ScholarshipApplicationService;
import com.sy.mobileback.common.utils.JsonResult;
import com.sy.mobileback.common.utils.StringUtils;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//import com.sy.mobileback.accessdb.service.ScholarshipApplicationService;

/**
 * 奖学金
 * @auther ShiYan.Shi
 * @create 2019/4/5   23:45
 */
@Controller
@RequestMapping("/scholarship")
public class ScholarshipApplicationController {
    @Autowired
    private ScholarshipApplicationService scholarshipApplicationService;

    /**
     * 奖学金申请
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/apply")
    public JsonResult scholarshipApply(@RequestBody ScholarshipapplicationEntity entity, HttpServletRequest request) {
        Claims claims = (Claims)request.getAttribute("CLAIMS");
        String userId = (String)claims.get("userId");
        //String userId = "bb47e847-85ed-4778-bba4-7b49ca915469";
        String applyID = scholarshipApplicationService.studyabroadApply(userId,entity);
        if (StringUtils.isNotEmpty(applyID)) {
            JsonResult jsonResult = JsonResult.ok();
            jsonResult.put("applyid",applyID);
            return jsonResult;
        }
        return JsonResult.error();
    }


}
