package org.example.weiyuntong.credit.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 赊销评级更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CreditConfigLevelUpdateReqVO extends CreditConfigLevelBaseVO {

    @Schema(description = "ID", required = true, example = "17150")
    @NotNull(message = "ID不能为空")
    private Long id;

}
