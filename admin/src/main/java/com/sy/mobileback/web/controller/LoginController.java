package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.domain.StudentEntity;
import com.sy.mobileback.accessdb.service.StudentService;
import com.sy.mobileback.common.utils.MD5Util;
import com.sy.mobileback.common.utils.StringUtils;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import com.sy.mobileback.framework.jwt.config.JwtParam;
import com.sy.mobileback.framework.jwt.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.UUID;

/**
 * @author shiyu
 * @Description
 * @create 2019-03-24 14:58
 */
@Controller
public class LoginController {

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
    public String userLogin(@RequestBody Map<String, String> person) {
        if (!(person.containsKey("username")) || !(person.containsKey("password"))) {
            return "-1";
        }
        String username = person.get("username");
        String password = person.get("password");
        // TODO 需要对 username和passwod判空
        // 先判断 username是否存在，如果存在返回 -1
        password = MD5Util.getMD5(password);
        String guid = studentService.userLogin(username,password);
        if (null==guid) {
            // 没有对应用户
            return "-1";
        }
        String token = JwtUtils.createToken(guid + "", jwtParam);
        if (null==token) {
            // 生成token存在问题
            return "-1";
        }
        return token;
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
        String token = JwtUtils.createToken(guid + "", jwtParam);
        if (null==token) {
            // 生成token存在问题
            return "-1";
        }
        return token;
    }

    /**
     * 修改密码，修改密码的前提是传过来有效的 token
     * @return
     */
    public String resetPassword(Map<String,String> person){
        return null;
    }


//    @JwtIgnore
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "测试 jwt";
    }

}
