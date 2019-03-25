package com.sy.mobileback.framework.jwt.annotations;

import java.lang.annotation.*;

/**
 * @author shiyu
 * @Description
 * @create 2019-03-24 15:06
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtIgnore {
}

