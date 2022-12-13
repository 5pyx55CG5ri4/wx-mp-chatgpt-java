package com.zly.wxpush.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * 基础信息
 *
 * @author 5pyx55CG5ri4
 * @date 2022/09/28
 */
@Data
public class BaseMessage {

    @XStreamAlias(value = "ToUserName")
    private String toUserName;

    @XStreamAlias(value = "FoUserName")
    private String fromUserName;

    @XStreamAlias(value = "CreateTime")
    private Long createTime;

    @XStreamAlias(value = "MsgType")
    private String msgType;

}
