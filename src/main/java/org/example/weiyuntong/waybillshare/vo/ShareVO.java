package org.example.weiyuntong.waybillshare.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ShareVO {
    @Schema(description = "链接码")
    private String code;

    @Schema(description = "验证码")
    private String smsCode;

    private String phone;

    private Long entId;
}
