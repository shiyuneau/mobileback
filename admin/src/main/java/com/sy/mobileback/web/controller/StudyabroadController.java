package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.LXApplyEntity;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shiyu
 * @Description 留学申请相关表
 * @create 2019-04-05 23:45
 */
@Controller
@RequestMapping("/studyabroad")
public class StudyabroadController {

    @JwtIgnore
    @RequestMapping("/apply")
    @ResponseBody
    public String studyabroadApply(@RequestBody LXApplyEntity entity) {

        String studentID = "bb47e847-85ed-4778-bba4-7b49ca915469";
        System.out.println();

        return "-1";
    }

}
