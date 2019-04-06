package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.LXApplyEntity;
import com.sy.mobileback.accessdb.domain.StudyabroadapplicationEntity;
import com.sy.mobileback.accessdb.service.StudyabroadService;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shiyu
 * @Description 留学申请相关表
 * @create 2019-04-05 23:45
 */
@Controller
@RequestMapping("/studyabroad")
public class StudyabroadController {

    @Autowired
    private StudyabroadService studyabroadService;

    @JwtIgnore
    @RequestMapping("/apply")
    @ResponseBody
    public String studyabroadApply(@RequestBody StudyabroadapplicationEntity entity , HttpServletRequest request) {
//        Claims claims = (Claims)request.getAttribute("CLAIMS");
//        String userId = (String)claims.get("userId");
        String userId = "bb47e847-85ed-4778-bba4-7b49ca915469";
        boolean applyResult = studyabroadService.studyabroadApply(userId,entity);
        if (applyResult) {
            return "1";
        }
        return "-1";
    }

}
