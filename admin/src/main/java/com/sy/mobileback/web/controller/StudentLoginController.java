package com.sy.mobileback.web.controller;

import com.alibaba.fastjson.JSONReader;
import com.sy.mobileback.accessdb.domain.StudentEntity;
import com.sy.mobileback.accessdb.service.StudentService;
import com.sy.mobileback.common.utils.JsonResult;
import com.sy.mobileback.common.utils.MD5Util;
import com.sy.mobileback.common.utils.StringUtils;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import com.sy.mobileback.framework.jwt.config.JwtParam;
import com.sy.mobileback.framework.jwt.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
    private JwtParam jwtParam;

    /**
     * 登录接口，需要传递 username password 两个参数
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
        String guid = studentService.userLogin(username,password);
        if (null==guid) {
            // 没有对应用户
            JsonResult result = JsonResult.error("用户不存在");
            return result;
        }
        String token = JwtUtils.createToken(guid + "", 0 , jwtParam);
        if (null==token) {
            // 生成token存在问题
            return JsonResult.error("token生成出错");
        }
        JsonResult result = JsonResult.ok();
        result.put("token",token);
        result.put("certificate","student");
        return result;
    }

    /**
     * 用户注册 ， 需要 username，password，email三个字段
     * @param person
     * @return
     */
    @JwtIgnore
    @PostMapping("/registry")
    @ResponseBody
    public String userRegistry(@RequestBody Map<String, String> person) {
        if (!(person.containsKey("username")) || !(person.containsKey("email"))|| !(person.containsKey("password"))) {
            return "-1";
        }
        String username = person.get("username");
        String password = person.get("password");
        String email = person.get("email");
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(email)) {
            // 用户输入有误
            return "-1";
        }
        String guid = studentService.userExist(username);
        if (null!=guid) {
            //用户存在
            return "-1";
        }

        // 插入数据库，并生成token
        guid = UUID.randomUUID().toString();
        password = MD5Util.getMD5(password);
        StudentEntity entity = new StudentEntity();
        entity.setGuid(guid);
        entity.setMail(email);
        entity.setUsername(username);
        entity.setPassword(password);
        studentService.newUserInsert(entity);
        String token = JwtUtils.createToken(guid + "",0, jwtParam);
        if (null==token) {
            // 生成token存在问题
            return "-1";
        }
        return token;
    }

    /**

     *  oldusername
     *  newusername
     * @return
     */
    /**
     * 修改密码，修改密码的前提是传过来有效的 token
     *  需要前端传递过来的参数:
     * @param person 前端
     *               head Authorization 中传递 登录 后传递的token
     *               body 传 过来的参数 ,包含:
     *               oldusername
     *               newusername
     *               email
     *               password
     *  需要根据 token中存储的userID 获得原名称  和 参数中传递的 oldusername ,如果相同，修改，如果不同，则返回 用户信息不匹配
     * @param request
     * @return
     */
    @PostMapping("/userinforeset")
    @ResponseBody
    public String resetPassword(@RequestBody Map<String,Object> person, HttpServletRequest request){
//        if (!(person.containsKey("oldusername"))) {
////            return "信息不全，重新输入";
//            return "-1";
//        }
        // 参数都为空，直接返回
        if (!(person.containsKey("username")) && !(person.containsKey("password")) &&!(person.containsKey("email"))) {
            return "-1";
        }
//        String oldusername = (String)person.get("oldusername");
        Claims claims = (Claims)request.getAttribute("CLAIMS");
        String userId = (String)claims.get("userId");
        int tokenInUse = (Integer)claims.get("inuse");
        if (tokenInUse != 1)  {
            return "-1";
        }
//        // 先判断 oldusername和 token对应的用户名是否一直
//        String orginUsername = studentService.usernameGet(userId);
//        // 判断 orginUsername 和 oldusername 是否相同， 如果相同，则进行修改的语句
//        if (!(orginUsername.equals(oldusername))) {
//            return "-1";
//        }
//        if (person.containsKey("newusername")) {
//            //如果要修改用户名称，先要判断当前的用户名称和原用户名称是否相同，如果相同返回-1
//            String newusername = (String)person.get("newusername");
//            if (newusername.equals(oldusername)) {
//                return "-1";
//            }
//            // 判断 数据库中是否又要修改的newusername
//            boolean userExists = studentService.usernameExists(newusername);
//            if (userExists) {
//                return "-1";
//            }
//        }
        String authToken = (String)request.getAttribute("token");
        Boolean updateFlag = studentService.updateUser(userId,person);
        if (updateFlag) {
            return authToken;
        } else {
            return "-1";
        }
    }

    /**
     * 密码修改接口，接口的需求 是 直接输入 邮箱，向邮箱发送一个8位的密码，让用户用这个八位的密码登录
     * 问题: 这里填写的邮箱是否和用户注册时的邮箱一至，学生表中的邮箱是否是唯一的，是否可以通过邮箱来确定一个唯一的一个用户
     * 现用户登录是通过username用户名登录，不是邮箱，邮箱和用户的匹配关系需要确定
     * @param email
     * @return
     */
    @JwtIgnore
    @PostMapping("/passwordreset")
    @ResponseBody
    public JsonResult passwordreset(@RequestParam("email") String email) {
        if (StringUtils.isEmpty(email) || StringUtils.isBlank(email)) {
            return JsonResult.error("请填写邮箱");
        }
        // TODO 是否需要验证邮箱的格式
        String newPass = studentService.passwordreset(email);
        if (StringUtils.isNotBlank(newPass)) {
            JsonResult result = JsonResult.ok();
            result.put("pass",newPass);
            return result;
        }
        return JsonResult.error();
    }

//    @JwtIgnore
    @PostMapping("/logout")
    @ResponseBody
    public JsonResult logout(HttpServletRequest request) {
        Claims claims = (Claims)request.getAttribute("CLAIMS");
        claims.put("inuse",0);
        return JsonResult.ok("退出成功");
    }


//    @JwtIgnore
    @PostMapping("/test")
    @ResponseBody
    public String test() {
        return "测试 jwt";
    }

}
