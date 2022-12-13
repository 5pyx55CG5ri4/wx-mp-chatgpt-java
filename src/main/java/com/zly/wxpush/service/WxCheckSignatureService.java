package com.zly.wxpush.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * wx检查签名服务
 *
 * @author 5pyx55CG5ri4
 * @date 2022/09/28
 */
public interface WxCheckSignatureService {

    /**
     * 消息处理
     *
     * @param request  请求
     * @param response 响应
     * @return {@link String}
     */
    String messageHandle(HttpServletRequest request, HttpServletResponse response);
}
