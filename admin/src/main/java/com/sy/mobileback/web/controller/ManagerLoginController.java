package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.ScholarshipapplicationEntity;
import com.sy.mobileback.accessdb.domain.StudyabroadapplicationEntity;
import com.sy.mobileback.accessdb.service.ManagerService;
import com.sy.mobileback.accessdb.service.ScholarshipApplicationService;
import com.sy.mobileback.accessdb.service.SchoolService;
import com.sy.mobileback.accessdb.service.StudyabroadService;
import com.sy.mobileback.common.utils.JsonResult;
import com.sy.mobileback.common.utils.MD5Util;
import com.sy.mobileback.common.utils.StringUtils;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import com.sy.mobileback.framework.jwt.config.JwtParam;
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
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-06 22:24
 */
@Controller
@RequestMapping("/manager")
public class ManagerLoginController {
    @Autowired
    private JwtParam jwtParam;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private ScholarshipApplicationService scholarshipApplicationService;
    @Autowired
    private StudyabroadService studyabroadService;
    @Autowired
    private SchoolService schoolService;

    /**
     * 管理员登录接口，需要传递 username password 两个参数
     *
     * @param person
     * @return
     */
    @JwtIgnore
    @PostMapping("/login")
    @ResponseBody
    public JsonResult userLogin(@RequestBody Map<String, String> person) {
        if (!(person.containsKey("username")) || !(person.containsKey("password"))) {
            return JsonResult.error("信息输入有误");
        }
        String username = person.get("username");
        String password = person.get("password");
        // TODO 需要对 username和passwod判空
        // 先判断 username是否存在，如果存在返回 -1
        password = MD5Util.getMD5(password);
        Map<String,String> map = managerService.userLogin(username, password);
        String guid = map.get("guid");
        if (null == guid) {
            // 没有对应用户
            JsonResult result = JsonResult.error("用户不存在");
            return result;
        }
        String token = JwtUtils.createToken(guid + "", 1, jwtParam);
        if (null == token) {
            // 生成token存在问题
            return JsonResult.error("token生成出错");
        }
        JsonResult result = JsonResult.ok();
        result.put("token", token);
        result.put("certificate", "manager");
        return result;
    }
    /**
     * 留学申请列表 需要传递 管理员id 参数
     *
     * @param request
     * @return
     */
    @ResponseBody
    @GetMapping("/studyabroadapplycheck")
    public List<StudyabroadapplicationEntity> StudyabroadApplyCheck( HttpServletRequest request, HttpServletResponse response) {
        Claims claims = (Claims)request.getAttribute("CLAIMS");
        String managerGUID = (String)claims.get("userId");
        //String userId = "bb47e847-85ed-4778-bba4-7b49ca915469";
        boolean falg = JwtUtils.managerTokenAndInuse(claims);
        if(!falg){
            return null;
        }
        return studyabroadService.applySuccessList(managerGUID);
    }
    /**
     * 留学审核 传参 applyid 申请ID
     *
     * @param applyid
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/studyabroadcheck")
    public JsonResult studyabroadcheck(@RequestParam("applyid") String applyid, HttpServletRequest request) {
        if (StringUtils.isEmpty(applyid) || StringUtils.isBlank(applyid)) {
            return JsonResult.error();
        }
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String userId = (String) claims.get("userId");
        boolean falg = JwtUtils.managerTokenAndInuse(claims);
        if(!falg){
            return JsonResult.error("用户过期或不是管理账户");
        }
        boolean result = studyabroadService.applyCheck(userId, applyid);
        if (result) {
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
    @GetMapping("/scholarshipapplycheck")
    public List<ScholarshipapplicationEntity> scholarcshipApplyCheck(HttpServletRequest request, HttpServletResponse response) {
        Claims claims = (Claims)request.getAttribute("CLAIMS");
        String managerGUID = (String)claims.get("userId");
        //String userId = "bb47e847-85ed-4778-bba4-7b49ca915469";
        boolean falg = JwtUtils.managerTokenAndInuse(claims);
        if(!falg){
            return null;
        }
        return scholarshipApplicationService.applySuccessList(managerGUID);
    }

    /**
     * 奖学金审核 传参 applyrecordid 奖学金记录ID
     *
     * @param applyrecordid
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/scholarcshipcheck")
    public JsonResult scholarcshipCheck(@RequestParam("applyrecordid") String applyrecordid, HttpServletRequest request) {
        if (StringUtils.isEmpty(applyrecordid) || StringUtils.isBlank(applyrecordid)) {
            return JsonResult.error();
        }
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String userId = (String) claims.get("userId");
        boolean falg = JwtUtils.managerTokenAndInuse(claims);
        if(!falg){
            return JsonResult.error("用户过期或不是管理账户");
        }
        boolean result = scholarshipApplicationService.applyCheck(userId, applyrecordid);
        if (result) {
            return JsonResult.ok();
        }
        return JsonResult.error();
    }

}
