package org.example.weiyuntong.credit.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - 赊销配置更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CreditConfigUpdateReqVO extends CreditConfigBaseVO {

    @Schema(description = "ID", required = false, example = "7092")
    private Long id;


}
