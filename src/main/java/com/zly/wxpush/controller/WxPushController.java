package com.zly.wxpush.controller;


import com.zly.wxpush.config.WxConfig;
import com.zly.wxpush.service.WxCheckSignatureService;
import com.zly.wxpush.util.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * wx推控制器
 *
 * @author 5pyx55CG5ri4
 * @date 2022/09/28
 */
@RestController
@RequestMapping("/wx")
public class WxPushController {

    @Autowired
    private WxCheckSignatureService wxCheckSignatureService;

    @Autowired
    private WxConfig wxConfig;


    /**
     * 验证
     */
    @GetMapping("login")
    public String validation(String signature, String timestamp, String nonce, String echostr) {
        if (CheckUtil.checkSignature(signature, timestamp, nonce, wxConfig.getCheckToken())) {
            return echostr;
        }
        return null;
    }

    /**
     * 消息处理
     *
     * @param request  请求
     * @param response 响应
     * @return {@link String}
     */
    @PostMapping("login")
    public String messageHandle(HttpServletRequest request, HttpServletResponse response) {
        return wxCheckSignatureService.messageHandle(request, response);
    }

}
