package com.sy.mobileback.web.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author shiyu
 * @Description
 * @create 2019-04-06 0:25
 */
@Component
@ConfigurationProperties(prefix = "mobileback")
public class FileConfig {


    /**
     * 版本
     */
    private String version;
    /**
     * 上传文件路径
     */
    private static String profile;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    public static String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        FileConfig.profile = profile;
    }

}
