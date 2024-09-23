package org.example.weiyuntong.billpay.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 登记付款 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillPayRespVO extends BillPayBaseVO {

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
