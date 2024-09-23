package org.example.weiyuntong.billpay.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 登记付款更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillPayUpdateReqVO extends BillPayBaseVO {

    @Schema(description = "ID", required = true, example = "6807")
    @NotNull(message = "ID不能为空")
    private Long id;

}
