package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.service.AlumniService;
import com.sy.mobileback.accessdb.service.SchoolService;
import com.sy.mobileback.common.constant.AccessConstants;
import com.sy.mobileback.common.utils.JsonResult;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import com.sy.mobileback.framework.jwt.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shiyu
 * @Description  校友录管理
 * @create 2019-04-27 15:50
 */
@Controller
@RequestMapping("/schoolmanage")
public class SchoolManageController {
    @Autowired
    private AlumniService alumniService;
    @Autowired
    private SchoolService schoolService;

    @GetMapping("/xyl/alumnilist")
    @ResponseBody
    public JsonResult alumniList(@RequestParam(value = "pageNum", required = false) Integer pageNum, @RequestParam(value = "pageSize", required = false) Integer pageSize , HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String managerGUID = (String) claims.get("userId");
        // 开始获取是高校管理员还是 教委管理员
        int userFlag = (Integer) claims.get("userFlag");
        if (userFlag != 1) {
            return JsonResult.error("不是高校管理者");
        }
        // 如果pagNum和pageSize都不传，只查前十页
        if (null == pageNum) {
            pageNum = 1;
        }
        if (null == pageSize) {
            pageSize = AccessConstants.PAGE_SIZE;
        }
        return alumniService.alumniList(pageSize,pageNum,managerGUID);
    }

    /**
     * 获取学校的介绍 和照片
     * @param request
     * @return
     */
    @GetMapping("/schinfo/schoolintro")
    @ResponseBody
    public JsonResult schoolIntroduction(HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String managerGUID = (String) claims.get("userId");
        // 开始获取是高校管理员还是 教委管理员
        int userFlag = (Integer) claims.get("userFlag");
        if (userFlag != 1) {
            return JsonResult.error("不是高校管理者");
        }
        return schoolService.introductionByMangerGUID(managerGUID);
    }

    /**
     * 获取学学院的信息
     * @param request
     * @return
     */
    @GetMapping("/schinfo/collegeinfo")
    @ResponseBody
    public JsonResult collegeinfo(HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String managerGUID = (String) claims.get("userId");
        // 开始获取是高校管理员还是 教委管理员
        int userFlag = (Integer) claims.get("userFlag");
        if (userFlag != 1) {
            return JsonResult.error("不是高校管理者");
        }
        return schoolService.collegeinfoByMangerGUID(managerGUID);
    }

    /**
     * 获取专业的信息
     * @param request
     * @return
     */
    @GetMapping("/schinfo/professioninfo")
    @ResponseBody
    public JsonResult professioninfo(HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String managerGUID = (String) claims.get("userId");
        // 开始获取是高校管理员还是 教委管理员
        int userFlag = (Integer) claims.get("userFlag");
        if (userFlag != 1) {
            return JsonResult.error("不是高校管理者");
        }
        return schoolService.professioninfoByMangerGUID(managerGUID);
    }
}
