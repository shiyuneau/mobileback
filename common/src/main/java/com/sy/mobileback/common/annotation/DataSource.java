package com.sy.mobileback.common.annotation;

import com.sy.mobileback.common.enums.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * 自定义配置多数据源注解
 * @author shiyu
 * @Description
 * @create 2019-02-24 15:28
 */
//代表作用在方法上
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    /**
     * 切换数据源名称
     * @return
     */
    DataSourceType value() default DataSourceType.MASTER ;
}
