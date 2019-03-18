package com.sy.mobileback.framework.aspectj;

import com.sy.mobileback.common.utils.StringUtils;
import com.sy.mobileback.common.annotation.DataSource;
import com.sy.mobileback.framework.datasource.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 *
 * 多数据源处理
 * @author shiyu
 * @Description
 * @create 2019-02-24 16:11
 */
@Aspect
@Order(1)
@Component
public class DataSourceAspect {
    protected Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("@annotation(com.sy.mobileback.common.annotation.DataSource)")
    public void dsPointCut() {

    }

    @Around("dsPointCut()")
    public Object arount(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();

        Method method = signature.getMethod();
        DataSource dataSource = method.getAnnotation(DataSource.class);

        if (StringUtils.isNotNull(dataSource)) {
            DynamicDataSourceContextHolder.setDataSourceType(dataSource.value().name());
        }

        try {
            return point.proceed();
        }
        finally {
            // 销毁数据源，在执行方法之后
            DynamicDataSourceContextHolder.clearDateSoureType();
        }
    }

}
