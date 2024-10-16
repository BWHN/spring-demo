package org.example.weiyuntong.billpayapply.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 付款申请更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillPayApplyUpdateReqVO extends BillPayApplyCreateReqVO {

    @Schema(description = "ID", required = true, example = "30539")
    @NotNull(message = "ID不能为空")
    private Long id;

}
