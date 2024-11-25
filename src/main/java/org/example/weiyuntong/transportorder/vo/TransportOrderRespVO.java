package org.example.weiyuntong.transportorder.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@Schema(description = "管理后台 - 订单 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TransportOrderRespVO extends TransportOrderBaseVO {

    @Schema(description = "待确认")
    private Long toSure;

    @Schema(description = "已确认")
    private Long sure;

    @Schema(description = "被拒绝")
    private Long refused;

    @Schema(description = "已撤销")
    private Long revoked;

    @Schema(description = "成交重量")
    private BigDecimal dealWeight;

    @Schema(description = "总重量")
    private BigDecimal totalWeight;

    @Schema(description = "撤销重量")
    private BigDecimal revokeWeight;

    @Schema(description = "指派信息id")
    private Long taskId;

    @Schema(description = "委托单类型")
    private WaybillTypeEnum type;

    @Schema(description = "承运商人")
    private String carrierName;

}
