package org.example.weiyuntong.wxmessage.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 微信回调接收 vo
 */

@Data
@NoArgsConstructor
public class WXMessage{

    private Long errorCode;

    private String errorStatus;

    private Long msgID;

    private Long templateId;

}
