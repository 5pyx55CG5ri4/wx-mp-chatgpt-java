package com.zly.wxpush.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 基础信息
 *
 * @author 5pyx55CG5ri4
 * @date 2022/09/28
 */
public class BaseMessage {

    @XStreamAlias(value = "ToUserName")
    private String toUserName;

    @XStreamAlias(value = "FoUserName")
    private String fromUserName;

    @XStreamAlias(value = "CreateTime")
    private Long createTime;

    @XStreamAlias(value = "MsgType")
    private String msgType;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
