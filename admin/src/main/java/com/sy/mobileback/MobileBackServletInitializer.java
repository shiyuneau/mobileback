package com.sy.mobileback;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author shiyu
 * @Description
 * @create 2019-02-24 16:47
 */
public class MobileBackServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(MobileBackApplication.class);
    }
}
