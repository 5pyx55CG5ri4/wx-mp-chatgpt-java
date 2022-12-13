package com.zly.wxpush.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.zly.wxpush.message.BaseMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 短信
 *
 * @author 5pyx55CG5ri4
 * @date 2022/10/14
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TextMessage extends BaseMessage {

    @XStreamAlias(value = "Content")
    private String content;


    public TextMessage() {
        this.setMsgType("text");
    }


}
