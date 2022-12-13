package com.zly.chatgpt.dto;


import com.alibaba.fastjson.annotation.JSONField;

/**
 * 完成要求参数
 *
 * @author 5pyx55CG5ri4
 * @date 2022/12/13
 */
public class CompletionsReqParams {

    private String model;

    private String prompt;

    private Double temperature;

    @JSONField(name = "max_tokens")
    private Integer maxTokens;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
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
}
