package com.zly.chatgpt.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * wx配置
 *
 * @author 5pyx55CG5ri4
 * @date 2022/09/27
 */
@Component
@ConfigurationProperties(prefix = "chatgpt-config")
public class ChatGptConfig {

    private String model;

    private Double temperature;

    private Integer maxTokens;

    private String apiKey;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}

