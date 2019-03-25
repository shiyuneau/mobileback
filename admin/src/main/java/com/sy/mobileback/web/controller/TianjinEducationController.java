package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.CollegeEntity;
import com.sy.mobileback.accessdb.domain.SchoolEntity;
import com.sy.mobileback.accessdb.service.CollegeService;
import com.sy.mobileback.accessdb.service.SchoolService;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author shiyu
 * @Description
 * @create 2019-03-23 18:22
 */
@Controller
@RequestMapping("/tjeducation")
public class TianjinEducationController {

    @Autowired
    private SchoolService schoolService;
    @Autowired
    private CollegeService collegeService;
    /**
     * 获取所有得大学及大学得 专业信息
     * @return
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/colleges")
    public List<SchoolEntity> collegesEntityList() {
        return schoolService.schoolList();
    }

    /**
     * 获取 指定 大学 或者 专业的 详细信息
     * 传递的参数 用 逗号 隔开
     */
    @JwtIgnore
    @ResponseBody
    @RequestMapping("/details")
    public String schoolOrCollegeDetails(@RequestParam("schoolGuid") String schoolGuid , @RequestParam("collegeGuid") String collegeGuid) {
        String result = null ;
        if (StringUtils.isNotEmpty(schoolGuid) && StringUtils.isNotEmpty(collegeGuid)) {
            // 查找 collegeDao
            CollegeEntity college = collegeService.collegeDetail(collegeGuid);
            if (null!=college) {
                result = "{ schoolGuid:" + schoolGuid + ",collegeGuid:" + collegeGuid + ",introduction:" + college.getIntroduction() + "}";
            }
        }
        if (StringUtils.isEmpty(collegeGuid) && StringUtils.isNotEmpty(schoolGuid)) {
            // 查找 schoolDao
            SchoolEntity school = schoolService.schoolDetail(schoolGuid);
            if (null != school) {
                result = "{ schoolGuid:" + schoolGuid + ",introduction:" + school.getIntroduction() + "}";
            }
        }
        return result;
    }

}
