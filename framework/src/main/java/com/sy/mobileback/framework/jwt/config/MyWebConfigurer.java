package com.sy.mobileback.framework.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * mvc 配置
 * Created by Hilox on 2018/11/15 0015.
 */
@Configuration
public class MyWebConfigurer extends WebMvcConfigurerAdapter {

    // 这里这么做是为了提前加载, 防止过滤器中@AutoWired注入为空
    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

    // 自定义过滤规则
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	//此部分原则上只对留学申请，用户信息等需要用户信息地方进行登陆验证
        registry.addInterceptor(jwtInterceptor()).addPathPatterns("/file/**","/manager/**","/student/**","/tool/gen/**","/scholarship/**","/studyabroad/**","/tjeducation/**")
        .excludePathPatterns("/static/**","classpath:/static/**");
    }
    
    /**
     * 配置静态访问资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
