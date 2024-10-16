package org.example.weiyuntong.billpayapply.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 付款申请 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillPayApplyRespVO extends BillPayApplyBaseVO {

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
