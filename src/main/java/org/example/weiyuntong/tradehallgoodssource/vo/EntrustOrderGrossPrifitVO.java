package org.example.weiyuntong.tradehallgoodssource.vo;

import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import com.weiyuntong.module.bizcenter.util.BigDecimalUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class EntrustOrderGrossPrifitVO {

    @Schema(description = "委托单id，报价时使用")
    private Long entrustOrderId;

    @Schema(description = "车辆ID，报价时使用")
    private Long carId;

    @Schema(description = "寻车运价，报价时，报价金额也会使用此字段")
    private BigDecimal searchCarPrice;

    @Schema(description = "委托运价")
    private BigDecimal entrustPrice;

    @Schema(description = "上游结算周期")
    private String upBillingCycle;

    @Schema(description = "结算周期(下游)")
    private String billingCycle;

    @Schema(description = "货物重量")
    private BigDecimal weight;

    @Schema(description = "货物重量")
    private BigDecimal carWeight;


    @Schema(description = "运价单位：元/吨、元/升、元/KG等,报价时使用此字段")
    private PriceUnitEnum priceUnit;

    @Schema(description = "运价单位：元/吨、元/升、元/KG等")
    private PriceUnitEnum searchCarPriceUnit;

    @Schema(description = "委托运价单位：元/吨、元/升、元/KG等")
    private PriceUnitEnum entrustPriceUnit;

    @Schema(description = "发货地经纬度", example = "183.128734,32.08723")
    private String startGps;

    @Schema(description = "收货地经纬度", example = "183.128734,32.08723")
    private String endGps;

    @Schema(description = "结算方式")
    private Integer settleType ;

    @Schema(description = "结算周期差值，当为负数时为0")
    private BigDecimal diffBillingCycle;

    @Schema(description = "上游是否开票")
    private Boolean upperNeedInvoice ;

    @Schema(description = "下游是否开票")
    private Boolean lowerNeedInvoice ;

    @Schema(description = "车辆数")
    private BigDecimal carNum;

    @Schema(description = "装货地距离")
    private BigDecimal loadingDistance;

    public BigDecimal getAmount() {
        return BigDecimalUtil.multiply(weight, searchCarPrice);
    }
}
