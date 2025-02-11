
package org.example.weiyuntong.tradehallgoodssource.vo.tradehall;

import com.weiyuntong.framework.common.util.StringUtil;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.OwnTypeEnum;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import com.weiyuntong.module.bizcenter.enums.SourceEnums;
import com.weiyuntong.module.bizcenter.util.BigDecimalUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "我要接单运力 Response VO")
@Data
@ToString(callSuper = true)
public class TradeHallOrderSourceVO {

    @Schema(description = "id")
    private Long id;
    private Long waybillSourceId;
    @Schema(description = "运单编号")
    private String waybillSourceNo;
    private String waybillNo;
    @Schema(description = "id")
    private Long waybillCarId;
    @Schema(description = "车次编号")
    private String waybillCarNo;
    @Schema(description = "上下游")
    private String from;
    @Schema(description = "分配运量")
    private BigDecimal weight;
    @Schema(description = "装货运量")
    private BigDecimal loadedWeight;
    @Schema(description = "卸货运量")
    private BigDecimal unloadedWeight;
    @Schema(description = "结算运量")
    private BigDecimal settleWeight;
    @Schema(description = "运价")
    private BigDecimal dealPrice;
    @Schema(description = "运价单位")
    private PriceUnitEnum dealPriceUnit;
    @Schema(description = "装货时间")
    private LocalDateTime loadedTime;
    @Schema(description = "卸货时间")
    private LocalDateTime unloadedTime;
    @Schema(description = "运单状态")
    private SourceEnums waybillStatus;
    @Schema(description = "车辆类型")
    private String carType;
    @Schema(description = "承运商名称")
    private String capacity;
    private String capacityId;
    private String consignorId;
    private String carrierEnterpriseName;
    private String carrierEnterpriseId;

    @Schema(description = "托运人")
    private String customerEnterpriseId;
    private String customerEnterpriseName;

    @Schema(description = "接单方")
    private String consignor;
    @Schema(description = "车牌号")
    private String carNumber;
    private String carId;
    @Schema(description = "司机")
    private String driverId;
    private String driverName;
    private String driverMobile;
    @Schema(description = "押运员")
    private String followId;
    private String followName;
    private String followMobile;
    @Schema(description = "创建人")
    private String creatorName;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;


    @Schema(description = "支付运费")
    private BigDecimal payAmount;
    @Schema(description = "补款/扣款")
    private BigDecimal exceptionAmount;
    @Schema(description = "成本")
    private BigDecimal ownAmount;
    @Schema(description = "佣金")
    private BigDecimal commissionAmount;
    @Schema(description = "车队费用+业务费用")
    private BigDecimal fleetAmount;

    @Schema(description = "上游支付费用（异常）")
    private BigDecimal topPayAmount;
    @Schema(description = "下游支付费用（异常）")
    private BigDecimal lowerPayAmount;


    @Schema(description = "能否添加成本费用 扣款/补偿(元)")
    private Boolean canAddedCosts = false;


    // 车辆所属
    private OwnTypeEnum ownType;

    public void handleCarType() {
        if (ownType != null) {
            if (OwnTypeEnum.OWN.equals(ownType) || OwnTypeEnum.LEASE.equals(ownType) || OwnTypeEnum.ATTACH.equals(ownType)) {
                this.carType = "自营";
            } else if (OwnTypeEnum.OTHER.equals(ownType)) {
                this.carType = "外协";
            } else if (OwnTypeEnum.SINGLE.equals(ownType)) {
                this.carType = "散车";
            }
        } else {
            this.carType = "外协";
        }
    }

    public BigDecimal getExceptionAmount() {
        return BigDecimalUtil.subtract(topPayAmount, lowerPayAmount);
    }

    public BigDecimal getOwnAmount(){
        return BigDecimalUtil.add(fleetAmount, commissionAmount);
    }
    public String getPrice() {
        return StringUtil.trimNull(dealPrice) + StringUtil.trimNull(dealPriceUnit == null ? "" : dealPriceUnit.getDesc());
    }

}
