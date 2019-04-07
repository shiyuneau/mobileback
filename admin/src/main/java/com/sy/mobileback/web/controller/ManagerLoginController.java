package com.sy.mobileback.web.controller;

import com.sy.mobileback.accessdb.service.ManagerService;
import com.sy.mobileback.common.utils.JsonResult;
import com.sy.mobileback.common.utils.MD5Util;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import com.sy.mobileback.framework.jwt.config.JwtParam;
import com.sy.mobileback.framework.jwt.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 管理员登录接口，需要传递 username password 两个参数
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
        String guid = managerService.userLogin(username,password);
        if (null==guid) {
            // 没有对应用户
            JsonResult result = JsonResult.error("用户不存在");
            return result;
        }
        String token = JwtUtils.createToken(guid + "", 1,jwtParam);
        if (null==token) {
            // 生成token存在问题
            return JsonResult.error("token生成出错");
        }
        JsonResult result = JsonResult.ok();
        result.put("token",token);
        result.put("certificate","manager");
        return result;
    }
}
