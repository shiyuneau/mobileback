package com.sy.mobileback.web.controller;

import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.sy.mobileback.accessdb.domain.ScholarshipapplicationEntity;
import com.sy.mobileback.accessdb.domain.StudyabroadapplicationEntity;
import com.sy.mobileback.accessdb.service.ManagerService;
import com.sy.mobileback.accessdb.service.ScholarshipApplicationService;
import com.sy.mobileback.accessdb.service.SchoolService;
import com.sy.mobileback.accessdb.service.StudyabroadService;
import com.sy.mobileback.common.annotation.Log;
import com.sy.mobileback.common.utils.JsonResult;
import com.sy.mobileback.common.utils.MD5Util;
import com.sy.mobileback.common.utils.StringUtils;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import com.sy.mobileback.framework.jwt.config.JwtParam;
import com.sy.mobileback.framework.jwt.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;

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
    @Log(title="管理员登录")
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
        Map<String, Object> map = managerService.userLogin(username, password);
        String guid = map.get("guid").toString();
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
     * 留学审核 传参 applyid 申请ID
     *
     * @param applyid
     * @param request
     * @return
     */
    @Log(title = "教委或高校审核留学申请")
    @ResponseBody
    @PostMapping("/studyabroadcheck")
    public JsonResult studyabroadcheck(@RequestParam("applyid") String applyid, @RequestParam("applyResultType") int appResultType, @RequestParam(value = "applyAdvice", required = false) String applyAdvice, HttpServletRequest request) {
        if (StringUtils.isEmpty(applyid) || StringUtils.isBlank(applyid)) {
            return JsonResult.error();
        }
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String userId = (String) claims.get("userId");
        boolean falg = JwtUtils.managerTokenAndInuse(claims);
        if (!falg) {
            return JsonResult.error("用户过期或不是管理账户");
        }
        boolean result = studyabroadService.applyCheck(userId, applyid, appResultType);
        if (result) {
            return JsonResult.ok();
        }
        return JsonResult.error();
    }

    @Log(title="教委或学校留学申请的申请列表")
    /**
     * 留学申请列表 需要传递 管理员id 参数
     *
     * @param request
     * @return
     */
    @ResponseBody
    @GetMapping("/studyabroadapplycheck")
    public List<StudyabroadapplicationEntity> StudyabroadApplyCheck(HttpServletRequest request, HttpServletResponse response) {
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String managerGUID = (String) claims.get("userId");
        //String userId = "bb47e847-85ed-4778-bba4-7b49ca915469";
        boolean falg = JwtUtils.managerTokenAndInuse(claims);
        if (!falg) {
            return null;
        }
        return studyabroadService.applyApplyedList(managerGUID);
    }


    /**
     * 奖学金申请列表 需要传递 userId 参数
     * 申请列表里面，需要根据 高校和 教委 不同用户，返回不同的 列表
     * 如果是高校，则返回 status为1 (待审批) 和 status = 6 (教委驳回) 的列表
     * 如果是教委，则返回 status为2 的列表，status 为 2,代表高校审批通过，但教委未审批
     *
     * @param request
     * @return
     */
    @Log(title = "管理员奖学金列表")
    @ResponseBody
    @GetMapping("/scholarshipapplycheck")
    public List<ScholarshipapplicationEntity> scholarcshipApplyCheck(HttpServletRequest request, HttpServletResponse response) {
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String managerGUID = (String) claims.get("userId");
        //String userId = "bb47e847-85ed-4778-bba4-7b49ca915469";
        boolean falg = JwtUtils.managerTokenAndInuse(claims);
        if (!falg) {
            return null;
        }
        // 开始获取是高校管理员还是 教委管理员
        List<ScholarshipapplicationEntity> entities = null;
        int userFlag = (Integer) claims.get("userFlag");
        if (userFlag == 1) {
            // 当前为高校管理员
            entities = scholarshipApplicationService.applyApplyedList(managerGUID, userFlag);
        } else if (userFlag == 2) {
            // 当前为 教委管理者
            entities = scholarshipApplicationService.applyApplyedList(managerGUID, userFlag);
        }
        return entities;
    }

    /**
     * 奖学金审核 传参 applyrecordid 奖学金记录ID
     *
     * @param applyid
     * @param request
     * @return
     */
    @Log(title = "奖学金审核")
    @ResponseBody
    @PostMapping("/scholarcshipcheck")
    public JsonResult scholarcshipCheck(@RequestParam("applyid") String applyid, @RequestParam("applyResultType") int applyResultType, @RequestParam(value = "applyAdvice",required = false) String applyAdvice, HttpServletRequest request) {
        if (StringUtils.isEmpty(applyid) || StringUtils.isBlank(applyid)) {
            return JsonResult.error();
        }
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String userId = (String) claims.get("userId");
        boolean falg = JwtUtils.managerTokenAndInuse(claims);
        if (!falg) {
            return JsonResult.error("用户过期或不是管理账户");
        }
        boolean result = false;
        int userFlag = (Integer) claims.get("userFlag");
        result = scholarshipApplicationService.applyCheck(userFlag, applyid, applyResultType, applyAdvice);
        if (result) {
            return JsonResult.ok();
        }
        return JsonResult.error();
    }


    /**
     * 留学申请数量统计
     * @param request
     * @return
     */
    @Log(title = "留学申请数量统计")
    @ResponseBody
    @GetMapping("/studyabroadApplyCount")
    public JsonResult studyabroadApplyCount(HttpServletRequest request) {

        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String userId = (String) claims.get("userId");
        boolean falg = JwtUtils.managerTokenAndInuse(claims);
        if (!falg) {
            return JsonResult.error("用户过期或不是管理账户");
        }
        int userFlag = (Integer) claims.get("userFlag");
        return studyabroadService.studyabroadApplyCount(userFlag,userId);
    }

    /**
     * 奖学金申请数量统计
     */
    @Log(title = "奖学金数量统计")
    @ResponseBody
    @GetMapping("/scholarshipApplyCount")
    public JsonResult scholarshipApplyCount(HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String userId = (String) claims.get("userId");
        boolean falg = JwtUtils.managerTokenAndInuse(claims);
        if (!falg) {
            return JsonResult.error("用户过期或不是管理账户");
        }
        int userFlag = (Integer) claims.get("userFlag");
        return scholarshipApplicationService.scholarshipApplyCount(userFlag,userId);
    }

    /**
     * 根据不同的类型，对留学申请做不同的统计
     * @param request
     * @param type
     * @return
     */
    @Log(title = "留学申请数量统计")
    @ResponseBody
    @GetMapping("/studyaboardanalysis")
    public JsonResult studyaboardAnalysis(HttpServletRequest request,@RequestParam("type") Integer type){
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String userId = (String) claims.get("userId");
        int userFlag = (Integer) claims.get("userFlag");
        if (userFlag!=2) {
            return JsonResult.error("请使用教委用户登录");
        }
        if (null == type) {
            return JsonResult.error("请输入正确的type");
        }
        return studyabroadService.studyaboardAnalysis(type);
    }

    /**
     * 根据不同的类型，对留学申请做不同的统计
     * @param request
     * @param type
     * @return
     */
    @Log(title="奖学金数量统计")
    @ResponseBody
    @GetMapping("/scholarshipanalysis")
    public JsonResult scholarshipanalysis(HttpServletRequest request,@RequestParam("type") Integer type){
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String userId = (String) claims.get("userId");
        int userFlag = (Integer) claims.get("userFlag");
        if (userFlag!=2) {
            return JsonResult.error("请使用教委用户登录");
        }
        if (null == type) {
            return JsonResult.error("请输入正确的type");
        }
        return scholarshipApplicationService.scholarshipAnalysis(type);
    }

    /**
     * 针对留学申请的 年度offer 接口
     *
     */
    @Log(title="留学年度offer")
    @ResponseBody
    @GetMapping("/studyapplyOfferYear")
    public JsonResult studyapplyOfferByYear(HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String userId = (String) claims.get("userId");
        int userFlag = (Integer) claims.get("userFlag");
        if (userFlag!=1) {
            return JsonResult.error("请使用高校用户登录");
        }
        return studyabroadService.studyOfferByYear(userId);
    }
}
