package org.example.weiyuntong.tradehallgoodssource.vo.tradehall;

import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.OwnTypeEnum;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import com.weiyuntong.module.bizcenter.enums.SettleStrategyEnum;
import com.weiyuntong.module.bizcenter.enums.SettleTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TradeHallOrderProcessExtraVO {

    @Schema(description = "id")
    private Long id;
    @Schema(description = "报价ID")
    private Long processId;
    @Schema(description = "车辆ID")
    private Long carId;
    @Schema(description = "车牌号")
    private String carNumber;
    @Schema(description = "车辆类型")
    private String carType;
    @Schema(description = "承运商")
    private String capacityName;
    @Schema(description = "承运商id")
    private Long capacityId;
    @Schema(description = "运量")
    private BigDecimal weight;
    @Schema(description = "价格-用车时填写的价格")
    private BigDecimal expectedPrice;
    @Schema(description = "价格单位", example = "17369")
    private PriceUnitEnum expectedPriceUnit ;
    @Schema(description = "损耗")
    private BigDecimal loss;
    @Schema(description = "损耗单位")
    private PriceUnitEnum lossUnit;
    @Schema(description = "结算策略")
    private SettleStrategyEnum settleStrategy;
    @Schema(description = "结算方式")
    private Integer settleType;
    @Schema(description = "结算方式枚举")
    private SettleTypeEnum settleTypeEnum;
    @Schema(description = "预计付款日期")
    private LocalDateTime payTime;
    @Schema(description = "是否需要开票")
    private Boolean lowerNeedInvoice;

    // 车辆所属
    private OwnTypeEnum ownType;

    public void handleData() {
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
        this.settleTypeEnum = SettleTypeEnum.instanceOf(this.settleType);
    }

}
