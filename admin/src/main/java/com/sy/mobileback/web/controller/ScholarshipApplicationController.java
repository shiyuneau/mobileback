package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.ScholarshipapplicationEntity;
import com.sy.mobileback.accessdb.service.ScholarshipApplicationService;
import com.sy.mobileback.common.utils.JsonResult;
import com.sy.mobileback.common.utils.StringUtils;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import com.sy.mobileback.framework.jwt.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 奖学金
 *
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
    @ResponseBody
    @PostMapping("/apply")
    public JsonResult scholarshipApply(@RequestBody ScholarshipapplicationEntity entity, HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String userId = (String) claims.get("userId");
        //String userId = "bb47e847-85ed-4778-bba4-7b49ca915469";
        boolean falg = JwtUtils.studentTokenAndInuse(claims);
        if(!falg){
            return JsonResult.error("用户过期或不是学生账户");
        }
        String applyID = scholarshipApplicationService.studyabroadApply(userId, entity);
        if (StringUtils.isNotEmpty(applyID)) {
            JsonResult jsonResult = JsonResult.ok();
            jsonResult.put("applyid", applyID);
            return jsonResult;
        }
        return JsonResult.error();
    }

    /**
     * 奖学金申请取消 需要传递 applyrecordid userId 参数
     *
     * @param applyrecordid
     * @param request
     * @return
     */
    @ResponseBody
    @GetMapping("/applycancel")
    public JsonResult scholarcshipApplyCancel(@RequestParam("applyrecordid") String applyrecordid, HttpServletRequest request) {
        if (StringUtils.isEmpty(applyrecordid) || StringUtils.isBlank(applyrecordid)) {
            return JsonResult.error();
        }
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String userId = (String) claims.get("userId");
        boolean falg = JwtUtils.studentTokenAndInuse(claims);
        if(!falg){
            return JsonResult.error("用户过期或不是学生账户");
        }
        //String userId = "bb47e847-85ed-4778-bba4-7b49ca915469";
        boolean flag = scholarshipApplicationService.applyCancel(userId, applyrecordid);
        if (flag) {
            return JsonResult.ok();
        }
        return JsonResult.error();

    }

    /**
     * 奖学金申请列表 需要传递 userId 参数
     *
     * @param request
     * @return
     */
    @ResponseBody
    @GetMapping("/applylist")
    public List<ScholarshipapplicationEntity> scholarcshipApplyList(HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String userId = (String) claims.get("userId");
        //String userId = "bb47e847-85ed-4778-bba4-7b49ca915469";
        return scholarshipApplicationService.scholarcshipApplyList(userId);
    }

    @ResponseBody
    @PostMapping("/applyUpdate")
    public JsonResult scholarshipApplyUpdate(@RequestBody ScholarshipapplicationEntity entity,HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String userId = (String) claims.get("userId");

        boolean updateResult = scholarshipApplicationService.sholarshipApplyUpdate(entity,userId);
        if (updateResult) {
            return JsonResult.ok(1,"更新成功，审批重新申请");
        } else {
            return JsonResult.ok(-1,"更新失败");
        }
    }

}
