package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.ManagerEntity;
import com.sy.mobileback.accessdb.domain.StudentEntity;
import com.sy.mobileback.accessdb.service.AlumniService;
import com.sy.mobileback.accessdb.service.ManagerService;
import com.sy.mobileback.accessdb.service.StudentService;
import com.sy.mobileback.common.annotation.Log;
import com.sy.mobileback.common.utils.JsonResult;
import com.sy.mobileback.common.utils.MD5Util;
import com.sy.mobileback.common.utils.StringUtils;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import com.sy.mobileback.framework.jwt.config.JwtParam;
import com.sy.mobileback.framework.jwt.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

/**
 * @author shiyu
 * @Description
 * @create 2019-03-24 14:58
 */
@Controller
@RequestMapping("/student")
public class StudentLoginController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private AlumniService alumniService;

    @Autowired
    private JwtParam jwtParam;

    /**
     * 登录接口，需要传递 username password 两个参数
     *
     * @param person
     * @return
     */
    @Log(title = "登录")
    @JwtIgnore
    @PostMapping("/login")
    @ResponseBody
    public JsonResult userLogin(@RequestBody Map<String, String> person) {
        if (!(person.containsKey("username")) || !(person.containsKey("password")) || !(person.containsKey("type"))) {
            return JsonResult.error("信息输入有误");
        }
        String username = person.get("username");
        String password = person.get("password");
        String type = person.get("type");
        // TODO 需要对 username和passwod判空
        // 先判断 username是否存在，如果存在返回 -1
        String certificate = null;
        Map<String, Object> mapResult = null;
        password = MD5Util.getMD5(password);
        if ("0".equals(type)) {
            mapResult = studentService.userLogin(username, password);

        } else if ("1".equals(type) || "2".equals(type)) {
            mapResult = managerService.userLogin(username, password);

        }
        if (null == mapResult) {
            return JsonResult.error("用户不存在");
        }
        String guid = mapResult.get("guid").toString();
        String token = "";
        if ("0".equals(type)) {
            /*
            学生
             */
            token = JwtUtils.createToken(guid + "", 0, jwtParam);
            certificate = "student";
        }else if ("1".equals(type)) {
            /*
            高校管理者
             */
            token = JwtUtils.createToken(guid + "", 1, jwtParam);
            certificate = "schoolmanager";
        } else if ("2".equals(type)) {
            /*
            教委管理者
             */
            token = JwtUtils.createToken(guid + "",2,jwtParam);
            certificate = "admin";
        }
        if (null == token) {
            // 生成token存在问题
            return JsonResult.error("token生成出错");
        }
        JsonResult result = JsonResult.ok();
        result.putAll(mapResult);
        result.put("token", token);
        result.put("certificate", certificate);
        return result;
    }

    /**
     * 用户注册 ， 需要 username，password，email三个字段
     * 根据type指定是学生注册还是高校注册
     *
     * @param person
     * @return
     */
    @Log(title = "注册")
    @JwtIgnore
    @PostMapping("/registry")
    @ResponseBody
    public JsonResult userRegistry(@RequestBody Map<String, String> person) {
        if (!(person.containsKey("username")) || !(person.containsKey("email")) || !(person.containsKey("password")) || !(person.containsKey("type"))) {
            return JsonResult.error("信息输入有误");
        }
        String username = person.get("username");
        String password = person.get("password");
        String email = person.get("email");
        String type = person.get("type");
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(email) || StringUtils.isEmpty(type)) {
            // 用户输入有误
            return JsonResult.error("信息输入有误");
        }
        String guid = null;

        if ("0".equals(type)) {
            // 开始的版本是username唯一，现变为email唯一
            guid = studentService.userExist(email);
        } else if ("1".equals(type)) {
            // TODO 再manager表中查询是否有这个用户名称和邮箱
            guid = managerService.userExist(email);

        }
        if (null != guid) {
            //用户存在
            return JsonResult.error("该注册邮箱已存在");
        }

        // 插入数据库，并生成token
        guid = UUID.randomUUID().toString();
        password = MD5Util.getMD5(password);
        String certificate = null;
        if ("0".equals(type)) {
            StudentEntity entity = new StudentEntity();
            entity.setGuid(guid);
            entity.setMail(email);
            entity.setUsername(username);
            entity.setPassword(password);
            studentService.newUserInsert(entity);
            certificate = "student";
        } else if ("1".equals(type)) {
            ManagerEntity entity = new ManagerEntity();
            entity.setGuid(guid);
            entity.setMail(email);
            entity.setUsername(username);
            entity.setPassword(password);
            managerService.newUserInsert(entity);
            certificate = "manager";
        }
        String token = JwtUtils.createToken(guid + "", 0, jwtParam);
        if (null == token) {
            // 生成token存在问题
            return JsonResult.error("token生成出错");
        }
        JsonResult result = JsonResult.ok();
        result.put("token", token);
        result.put("certificate", certificate);
        return result;
    }

    /**
     *  oldusername
     *  newusername
     * @return
     */
    /**
     * 修改密码，修改密码的前提是传过来有效的 token
     * 需要前端传递过来的参数:
     *
     * @param person  前端
     *                head Authorization 中传递 登录 后传递的token
     *                body 传 过来的参数 ,包含:
     *                oldusername
     *                newusername
     *                email
     *                password
     *                需要根据 token中存储的userID 获得原名称  和 参数中传递的 oldusername ,如果相同，修改，如果不同，则返回 用户信息不匹配
     *                对邮箱做校验，邮箱如果存在，则返回错误提示
     * @param request
     * @return
     */
    @Log(title = "信息修改")
    @PostMapping("/userinforeset")
    @ResponseBody
    public JsonResult resetPassword(@RequestBody Map<String, Object> person, HttpServletRequest request) {
        // 参数都为空，直接返回
        if (!(person.containsKey("username")) && !(person.containsKey("password")) && !(person.containsKey("email")) && !(person.containsKey("type"))) {
            return JsonResult.error("信息输入有误");
        }
//        String oldusername = (String)person.get("oldusername");
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        String userId = (String) claims.get("userId");
        int tokenInUse = (Integer) claims.get("inuse");
        if (tokenInUse != 1) {
            return JsonResult.error("信息输入有误");
        }
        // 判断邮箱是否存在
        String type = person.get("type").toString();

        Boolean updateFlag = false;
        String authToken = null;
        if ("0".equals(type)) {
            // 先判断是否有这个ID用户
            String username = studentService.usernameGet(userId);
            if (null==username) {
                return JsonResult.error("用户不存在");
            }
            if (person.containsKey("email")) {
                String email = person.get("email").toString();
                String emaiExist = studentService.userExist(email);
                if (null != emaiExist) {
                    return JsonResult.error("邮箱已存在");
                }
            }
            authToken = (String) request.getAttribute("token");
            updateFlag = studentService.updateUser(userId, person);
        }
        if ("1".equals(type)) {
            String username = managerService.usernameGet(userId);
            if (null==username) {
                return JsonResult.error("用户不存在");
            }
            if (person.containsKey("email")) {
                String email = person.get("email").toString();
                String emaiExist = managerService.userExist(email);
                if (null != emaiExist) {
                    return JsonResult.error("邮箱已存在");
                }
            }
            authToken = (String) request.getAttribute("token");
            updateFlag = managerService.updateUser(userId, person);
        }
        if (updateFlag) {
            JsonResult result = JsonResult.ok();
            result.put("token", authToken);
            return result;
        } else {
            return JsonResult.error("未知错误");
        }
    }

    /**
     * 密码修改接口，接口的需求 是 直接输入 邮箱，向邮箱发送一个8位的密码，让用户用这个八位的密码登录
     * 问题: 这里填写的邮箱是否和用户注册时的邮箱一至，学生表中的邮箱是否是唯一的，是否可以通过邮箱来确定一个唯一的一个用户
     * 现用户登录是通过username用户名登录，不是邮箱，邮箱和用户的匹配关系需要确定
     *
     * @param email
     * @return
     */
    @Log(title = "密码修改")
    @JwtIgnore
    @PostMapping("/passwordreset")
    @ResponseBody
    public JsonResult passwordreset(@RequestParam("email") String email) {
        if (StringUtils.isEmpty(email) || StringUtils.isBlank(email)) {
            return JsonResult.error("请填写邮箱");
        }
        // TODO 是否需要验证邮箱的格式
        // 先判断邮箱是否存在
        // userExist 方法如果用户存在，则返回 -1 ，
        String emailExists = studentService.userExist(email);
        if (null == emailExists) {
            return JsonResult.error("用户不存在");
        }
        boolean resetFlag = studentService.passwordreset(email);
        if (resetFlag) {
            JsonResult result = JsonResult.ok();
            result.put("msg", "密码更新成功，请检查邮箱");
            return result;
        }
        return JsonResult.error("密码更新错误，请联系管理员");
    }

    //    @JwtIgnore
    @PostMapping("/logout")
    @ResponseBody
    public JsonResult logout(HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        claims.put("inuse", 0);
        return JsonResult.ok("退出成功");
    }

    @Log(title = "校友搜索")
    @JwtIgnore
    @GetMapping("/alumnisearch")
    @ResponseBody
    public JsonResult alumniSearch(@RequestParam("username") String username) {
        if (org.apache.commons.lang3.StringUtils.isBlank(username)) {
            return JsonResult.error("搜索姓名不能为空");
        }
        return alumniService.alumniSearchByName(username);
    }


    //    @JwtIgnore
    @PostMapping("/test")
    @ResponseBody
    public String test() {
        return "测试 jwt";
    }

}
