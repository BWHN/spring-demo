package org.example.weiyuntong.bizimprest.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "备用金信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BizImprestUpdateReqVO extends BizImprestBaseVO {

    @Schema(description = "id", required = true, example = "9851")
    @NotNull(message = "id不能为空")
    private Long id;

}
