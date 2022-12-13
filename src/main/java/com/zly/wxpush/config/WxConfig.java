package com.zly.wxpush.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * wx配置
 *
 * @author 5pyx55CG5ri4
 * @date 2022/09/27
 */
@Component
@ConfigurationProperties(prefix = "wx-config")
public class WxConfig {

    private String appId;

    private String appSecret;

    private String checkToken;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getCheckToken() {
        return checkToken;
    }

    public void setCheckToken(String checkToken) {
        this.checkToken = checkToken;
    }
}

