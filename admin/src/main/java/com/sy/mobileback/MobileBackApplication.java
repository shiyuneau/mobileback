package com.sy.mobileback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * @author shiyu
 * @Description
 * @create 2019-02-24 16:45
 */

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.sy.mobileback.*.mapper")
public class MobileBackApplication {
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(MobileBackApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  手机后台启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}