package org.example.weiyuntong.tradehallgoodssource.vo.tradehall;

import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.OwnTypeEnum;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import com.weiyuntong.module.bizcenter.enums.SettleStrategyEnum;
import com.weiyuntong.module.bizcenter.enums.SettleTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "我要接单运力 Response VO")
@Data
@ToString(callSuper = true)
public class TradeHallOrderProcessVO {

    @Schema(description = "id")
    private Long id;
    @Schema(description = "车辆类型")
    private String carType;
    @Schema(description = "付款人ID")
    private Long carrierId;
    @Schema(description = "付款人名称")
    private String carrier;
    @Schema(description = "承运商")
    private String capacityName;
    @Schema(description = "承运商id")
    private Long capacityId;
    @Schema(description = "接单方")
    private String consignor;
    @Schema(description = "车辆ID")
    private Long carId;
    @Schema(description = "车辆荷载")
    private BigDecimal carMaxwgt;
    @Schema(description = "车牌号")
    private String carNumber;
    @Schema(description = "运量")
    private BigDecimal weight;
    @Schema(description = "期望运价")
    private BigDecimal expectedPrice;
    @Schema(description = "期望运价单位")
    private PriceUnitEnum expectedPriceUnit;
    @Schema(description = "装货时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime loadDate;
    @Schema(description = "卸货时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime unloadDate;
    @Schema(description = "结算策略")
    private SettleStrategyEnum settleStrategy;
    @Schema(description = "结算方式")
    private Integer settleType;
    @Schema(description = "结算方式枚举")
    private SettleTypeEnum settleTypeEnum;
    @Schema(description = "支付时间")
    private LocalDateTime payTime;
    @Schema(description = "下游是否需要开票")
    private Boolean lowerNeedInvoice;
    @Schema(description = "接单方预计毛利润")
    private BigDecimal grossProfit;
    @Schema(description = "发起方预计毛利润")
    private BigDecimal startGrossProfit;
    @Schema(description = "司机ID")
    private Long masterId;
    @Schema(description = "司机名称")
    private String masterName;

    @Schema(description = "上载货物名称")
    private String lastMediumName;
    @Schema(description = "上载货物id , 小程序用")
    private Long lastLoadRecordId;

    @Schema(description = "外部平台运单号")
    private String merchantOrder;

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
