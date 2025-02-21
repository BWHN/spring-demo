package org.example.weiyuntong.waybillshare.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;

/**
* 运单分享记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class WaybillShareBaseVO {

    @Schema(description = "运单id", example = "7597")
    private Long waybillId;

    @Schema(description = "是否生效")
    private Boolean unlock;

    @Schema(description = "受邀人手机号")
    private String phone;

    @Schema(description = "编号")
    private String code;

    @Schema(description = "短信验证码id", example = "28178")
    private Long smsId;

    @Schema(description = "浏览次数")
    private Integer browseNum;

}
