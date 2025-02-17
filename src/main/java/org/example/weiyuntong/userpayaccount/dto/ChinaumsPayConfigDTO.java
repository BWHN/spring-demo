package org.example.weiyuntong.userpayaccount.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ChinaumsPayConfigDTO {

    @Schema(description = "appId")
    private String appId;
    @Schema(description = "appKey")
    private String appKey;
    @Schema(description = "商户号")
    private String mchnId;
    @Schema(description = "系统编号")
    private String sysId;
    @Schema(description = "终端号")
    private String termId;
    @Schema(description = "通讯秘钥")
    private String communicationKey;
    @Schema(description = "接入来源")
    private String appSource;
    @Schema(description = "公钥")
    private String publicKey;
    @Schema(description = "私钥")
    private String privateKey;

}
