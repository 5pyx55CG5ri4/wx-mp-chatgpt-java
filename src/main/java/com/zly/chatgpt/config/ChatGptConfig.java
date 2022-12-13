package com.zly.chatgpt.config;


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
@ConfigurationProperties(prefix = "chatgpt-config")
public class ChatGptConfig {

    private String model;

    private Double temperature;

    private Integer maxTokens;

    private String apiKey;
}

