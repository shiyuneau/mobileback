package com.sy.mobileback.framework.jwt.config;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sy.mobileback.common.json.JSON;
import com.sy.mobileback.framework.exception.user.UserNoLoginException;
import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import com.sy.mobileback.framework.jwt.constants.JwtConstants;
import com.sy.mobileback.framework.jwt.utils.JwtUtils;
import com.sy.mobileback.framework.web.domain.ResponseResult;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * jwt 拦截器
 * Created by Hilox on 2018/11/16 0016.
 */
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtParam jwtParam;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 忽略带JwtIgnore注解的请求, 不做后续token认证校验
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
            if (jwtIgnore != null) {
                return true;
            }
        }

        if (HttpMethod.OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        final String authHeader = request.getHeader(JwtConstants.AUTH_HEADER_KEY);

        if (StringUtils.isEmpty(authHeader)) {
            // TODO 这里自行抛出异常
            JwtUtils.printJson(response,10001,"===== 用户未登录, 请先登录 =====");
            log.info("===== 用户未登录, 请先登录 =====");
            return false;
        }

        // 校验头格式校验
        if (!JwtUtils.validate(authHeader)) {
            // TODO 这里自行抛出异常
            log.info("===== token格式异常 =====");
            return false;
        }

        // token解析
        final String authToken = JwtUtils.getRawToken(authHeader);
        Claims claims = JwtUtils.parseToken(response,authToken, jwtParam.getBase64Secret());
        if (claims == null) {
            log.info("===== token解析异常 =====");
            return false;
        }

        // 传递所需信息
         request.setAttribute("CLAIMS", claims);
        request.setAttribute("token",authToken);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }



}
