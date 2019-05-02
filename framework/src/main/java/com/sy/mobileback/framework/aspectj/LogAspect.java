package com.sy.mobileback.framework.aspectj;

import com.alibaba.fastjson.JSONObject;
import com.sy.mobileback.common.annotation.Log;
import com.sy.mobileback.common.utils.HttpContextUtils;
import com.sy.mobileback.common.utils.IpUtils;
import com.sy.mobileback.system.domain.SysOperLog;
import com.sy.mobileback.system.mapper.SysOperLogDao;
import io.jsonwebtoken.Claims;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {
    @Autowired
    SysOperLogDao sysOperLogMapper;

    @Pointcut("@annotation(com.sy.mobileback.common.annotation.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 获取访问的URl 服务器
//		String url = "http://172.16.8.19:8182/cdn_work_v3"+request.getRequestURI();
        // 本地
        String url = request.getRequestURI();
        // 保存日志

        saveLog(url, point, time);
        return result;
    }

    private void saveLog(String url, ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysOperLog sysLog = new SysOperLog();
        Log syslog = method.getAnnotation(Log.class);
        if (syslog != null) {
            // 注解上的描述
            sysLog.setTitle(syslog.title());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        // 请求的参数
        Object[] args = joinPoint.getArgs();
        StringBuilder param = new StringBuilder();
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            if (args[i] == null) {
                continue;
            }
            if (args[i] instanceof HttpServletRequest || args[i] instanceof HttpServletResponse) {
                param.append("");
            } else {
                String json = JSONObject.toJSON(args[i]).toString();

                if (i == 0) {
                    param.append(json);
                } else {
                    param.append(",").append(json);
                }
            }
        }
        if (methodName.equals("login")) {
            sysLog.setOperParam("");
        } else {
            sysLog.setOperParam(param.toString());
        }
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        sysLog.setOperIp(IpUtils.getIpAddr(request));
        Claims claims = (Claims) request.getAttribute("CLAIMS");
        if (null!=claims && claims.containsKey("userId")) {
            String userid = (String) claims.get("userId");
            sysLog.setOperName(userid);
        } else {
            sysLog.setOperName("");
        }
//		sysLog.setTime((int) time);
        // 系统当前时间
        Date date = new Date();
        sysLog.setOperTime(date);
        // 访问的URl
        sysLog.setOperUrl(url);
        // 保存系统日志
        sysOperLogMapper.insertOperlog(sysLog);
    }
}
