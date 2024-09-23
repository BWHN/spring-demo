package org.example.weiyuntong.billpay.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - 登记付款创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillPayCreateReqVO extends BillPayBaseVO {

    @Schema(description = "是否忽略")
    private Integer isIgnore;
    @Schema(description = "付款账户Id")
    private Long payAccountId;

}
