package com.zly.wxpush.service.impl;


import com.zly.chatgpt.ChatGptUtil;
import com.zly.wxpush.constant.WxConstant;
import com.zly.wxpush.service.WxCheckSignatureService;
import com.zly.wxpush.util.WxPushMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * impl wx检查签名服务
 *
 * @author 5pyx55CG5ri4
 * @date 2022/09/28
 */
@Service
public class WxCheckSignatureServiceImpl implements WxCheckSignatureService {

    @Autowired
    private WxPushMessageUtil messageUtil;

    @Autowired
    private ChatGptUtil chatGptUtil;

    @Override
    public String messageHandle(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = messageUtil.parseXml(request);
        System.out.println("map {}" + map);
        String msgType = map.get(WxConstant.MSG_TYPE_NAME);
        return autoResp(msgType, map);
    }

    /**
     * 根据消息类型自动回复
     */
    private String autoResp(String type, Map<String, String> map) {
        String openId = map.get(WxConstant.FROM_USER_NAME);
        String toUserName = map.get(WxConstant.TO_USER_NAME);
        String msgId = map.get(WxConstant.MSG_ID);
        String content = map.get(WxConstant.CONTENT);
        switch (type) {
            // 文本类型
            case WxConstant.RESP_MESSAGE_TYPE_TEXT:
                String msg = chatGptUtil.chatGptMsg(content, msgId);
                return messageUtil.sendCustomText(openId, toUserName, msg);
            // 关注 和 取消关注类型
            case WxConstant.REQ_MESSAGE_TYPE_EVENT:
                if (map.get(WxConstant.EVENT_NAME).equals(WxConstant.SUBSCRIBE_NAME)) {
                    //发送关注文案
                    return messageUtil.sendCustomText(openId, toUserName, "");
                } else {
                    return null;
                }
            default:
                return null;

        }
    }

}
