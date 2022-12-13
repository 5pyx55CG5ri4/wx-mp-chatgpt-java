package com.zly.chatgpt;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zly.chatgpt.config.ChatGptConfig;
import com.zly.chatgpt.constant.ChatGptConstant;
import com.zly.chatgpt.dto.CompletionsReqParams;
import com.zly.wxpush.util.OptionalString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;


/**
 * 聊天gpt跑龙套
 *
 * @author 5pyx55CG5ri4
 * @date 2022/12/13
 */
@Component
@Slf4j
public class ChatGptUtil {

    @Autowired
    private ChatGptConfig chatGptConfig;

    private static final Cache<String, String> MSG_CACHE = CacheUtil.newLFUCache(100);

    private static final Cache<String, Integer> COUNT_CACHE = CacheUtil.newLFUCache(100);

    private static final Cache<String, String> TEXT_CACHE = CacheUtil.newLFUCache(100);


    public String chatGptMsg(String prompt, String msgId) {
        int count = Optional.ofNullable(COUNT_CACHE.get(msgId)).orElse(1);
        String cache = MSG_CACHE.get(msgId);
        if (StrUtil.isNotBlank(cache)) {
            return cache;
        }
        if (count >= 3) {
            return OptionalString.ofNullable(TEXT_CACHE.get(prompt)).orElse("还在学习中,请稍后再试....");
        }
        COUNT_CACHE.put(msgId, count + 1);
        HttpRequest post = HttpUtil.createPost(ChatGptConstant.COMPLETIONS_URL);
        post.header(ChatGptConstant.AUTHORIZATION, ChatGptConstant.BEARER.concat(chatGptConfig.getApiKey()));
        CompletionsReqParams completionsReqParams = new CompletionsReqParams();
        completionsReqParams.setModel(chatGptConfig.getModel());
        completionsReqParams.setTemperature(chatGptConfig.getTemperature());
        completionsReqParams.setMaxTokens(chatGptConfig.getMaxTokens());
        completionsReqParams.setPrompt(prompt);
        post.body(JSONObject.toJSONString(completionsReqParams));
        log.info("body is {}", completionsReqParams.toString());
        HttpResponse execute = post.execute();
        String body = execute.body();
        log.info("execute body is {}", body);
        JSONObject jsonObject = JSONObject.parseObject(body);
        JSONArray choices = jsonObject.getJSONArray(ChatGptConstant.CHOICES);
        String ret = choices.stream().map(JSONObject::toJSONString)
                .map(JSONObject::parseObject)
                .map(s -> s.getString(ChatGptConstant.TEXT))
                .collect(Collectors.joining("\n"));
        MSG_CACHE.put(msgId, ret);
        TEXT_CACHE.put(prompt, ret);
        return ret;
    }
}
