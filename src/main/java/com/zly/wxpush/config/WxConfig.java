package com.zly.wxpush.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * wx配置
 *
 * @author 5pyx55CG5ri4
 * @date 2022/09/27
 */
@Component
@Data
@ConfigurationProperties(prefix = "wx-config")
public class WxConfig {

    private String appId;

    private String appSecret;

    private String checkToken;
}

