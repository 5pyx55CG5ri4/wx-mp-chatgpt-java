package com.zly.chatgpt.dto;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 完成要求参数
 *
 * @author 5pyx55CG5ri4
 * @date 2022/12/13
 */
@Data
public class CompletionsReqParams {

    private String model;

    private String prompt;

    private Double temperature;

    @JSONField(name = "max_tokens")
    private Integer maxTokens;
}
