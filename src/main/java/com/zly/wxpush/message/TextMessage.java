package com.zly.wxpush.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * 短信
 *
 * @author 5pyx55CG5ri4
 * @date 2022/10/14
 */

public class TextMessage extends BaseMessage {

    @XStreamAlias(value = "Content")
    private String content;


    public TextMessage() {
        this.setMsgType("text");
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
