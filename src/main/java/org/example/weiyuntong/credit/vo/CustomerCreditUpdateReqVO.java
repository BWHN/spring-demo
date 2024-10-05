package org.example.weiyuntong.credit.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 客户赊销更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CustomerCreditUpdateReqVO extends CustomerCreditBaseVO {

    @Schema(description = "ID", required = true, example = "6764")
    @NotNull(message = "ID不能为空")
    private Long id;

}
