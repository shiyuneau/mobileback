package com.sy.mobileback.web.core.config;

import com.sy.mobileback.common.config.Global;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 的接口配置
 * @author shiyu
 * @Description
 * @create 2019-02-28 19:02
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 创建API
     */
    @Bean
    public Docket createRestApi() {
      return new Docket(DocumentationType.SWAGGER_2)
                // 详细定制
              .apiInfo(apiInfo())
              .select()
              // 指定当前包路径
              .apis(RequestHandlerSelectors.basePackage("com.sy.mobileback.web"))
              // 扫描所有
              .paths(PathSelectors.any())
              .build();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo() {
        // 用APIInfoBuilder进行定制
        return new ApiInfoBuilder()
                .title("标题:接口文档")
                .description("描述:用户各个接口的管理")
                .contact(new Contact(Global.getName(),null,null))
                .version("版本号:" + Global.getVersion())
                .build();
    }
}
