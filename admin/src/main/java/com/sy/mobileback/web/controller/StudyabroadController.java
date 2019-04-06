package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.StudyabroadapplicationEntity;
import com.sy.mobileback.accessdb.service.StudyabroadService;
import com.sy.mobileback.common.utils.JsonResult;
import com.sy.mobileback.common.utils.StringUtils;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

    /**
     * 留学申请
     * @param entity
     * @param request
     * @return
     */
//    @JwtIgnore
    @PostMapping("/apply")
    @ResponseBody
    public JsonResult studyabroadApply(@RequestBody StudyabroadapplicationEntity entity , HttpServletRequest request) {

        Claims claims = (Claims)request.getAttribute("CLAIMS");
        String userId = (String)claims.get("userId");
//        String userId = "bb47e847-85ed-4778-bba4-7b49ca915469";
        String applyID = studyabroadService.studyabroadApply(userId,entity);
        if (StringUtils.isNotBlank(applyID)) {
            JsonResult result = JsonResult.ok();
            result.put("applyid",applyID);
            return result;
        }
        return JsonResult.error();
    }


    @JwtIgnore
    @GetMapping("/applycancel")
    @ResponseBody
    public JsonResult studyabroadApplyCancel(@RequestParam("applyid") String applyid , HttpServletRequest request) {
        if (StringUtils.isBlank(applyid) || StringUtils.isEmpty(applyid)) {
            return JsonResult.error();
        }
        Claims claims = (Claims)request.getAttribute("CLAIMS");
//        String userId = (String)claims.get("userId");
        String userId = "a470adfa-b643-40a7-a0ed-82d40813e029";
        boolean cancelFlag = studyabroadService.applyCancel(userId,applyid);
        return JsonResult.error();
    }

}
