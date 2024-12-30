package org.example.weiyuntong.waybillcarbenefitpredict.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class WaybillCarBenefitPredictDetailVO extends WaybillCarBenefitPredictBaseVO {

    @Schema(description = "id")
    private Long id;
    @Schema(description = "车次ID")
    private Long waybillCarId;
    @Schema(description = "车次号")
    private String waybillCarNo;
    @Schema(description = "车次状态")
    private WaybillStatusEnum waybillStatus;
    @Schema(description = "装货地址")
    private String loadedAddrDesc;
    @Schema(description = "卸货地址")
    private String unloadedAddrDesc;
    @Schema(description = "装货时间")
    private LocalDateTime loadedTime;
    @Schema(description = "卸货时间")
    private LocalDateTime unloadedTime;
    @Schema(description = "空车里程")
    private BigDecimal emptyMileage;
    @Schema(description = "重车里程")
    private BigDecimal loadedMileage;
    @Schema(description = "总里程")
    private BigDecimal totalMileage;
    @Schema(description = "空车ETC")
    private BigDecimal emptyEtcCost;
    @Schema(description = "重车ETC")
    private BigDecimal loadedEtcCost;
    @Schema(description = "总ETC")
    private BigDecimal totalEtcCost;
    @Schema(description = "重车路桥费")
    private BigDecimal loadedRoadBridgeCost;
    @Schema(description = "空车路桥费")
    private BigDecimal emptyRoadBridgeCost;
    @Schema(description = "总路桥费")
    private BigDecimal totalRoadBridgeCost;

    @Schema(description = "油价")
    private BigDecimal oilPrice;
    @Schema(description = "税点")
    private BigDecimal taxPoint;
    @Schema(description = "重车司机提成")
    private BigDecimal loadedDriverPercentage;
    @Schema(description = "空车司机提成")
    private BigDecimal emptyDriverPercentage;
    @Schema(description = "重车油耗")
    private BigDecimal loadedOilConsumption;
    @Schema(description = "空车油耗")
    private BigDecimal emptyOilConsumption;
    @Schema(description = "固定成本均摊")
    private BigDecimal fixedCost;
    @Schema(description = "账期成本")
    private BigDecimal billCost;
    @Schema(description = "单日资金成本")
    private BigDecimal fundCost;
    @Schema(description = "尿素价格")
    private BigDecimal ureaPrice;
    @Schema(description = "百升尿素消耗")
    private BigDecimal ureaConsumption;
    @Schema(description = "承兑成本")
    private BigDecimal settleRate;
    @Schema(description = "单日人工成本")
    private BigDecimal personCost;
    
}
