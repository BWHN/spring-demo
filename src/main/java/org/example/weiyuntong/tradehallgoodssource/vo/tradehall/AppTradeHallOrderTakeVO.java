package org.example.weiyuntong.tradehallgoodssource.vo.tradehall;

import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import com.weiyuntong.module.bizcenter.enums.SettleStrategyEnum;
import com.weiyuntong.module.bizcenter.enums.SettleTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "司机扫码报价 Response VO")
@Data
@ToString(callSuper = true)
public class AppTradeHallOrderTakeVO {

    @Schema(description = "id")
    private Long id;
    @Schema(description = "订单ID")
    private Long orderId;
    @Schema(description = "订单编号")
    private String orderCode;
    @Schema(description = "托运人")
    private String consignor;
    @Schema(description = "托运人ID")
    private Long consignorId;

    @Schema(description = "是否允许报不同价格1.是，0不是")
    private Boolean isQuotePrice;
    @Schema(description = "寻车运价")
    private BigDecimal searchCarPrice;
    @Schema(description = "寻车运价单位：元/吨、元/升、元/KG等")
    private PriceUnitEnum searchCarPriceUnit;

    // 预置扣款项
    private List<String> presetDeduction;

    @Schema(description = "下游是否需要开票")
    private Boolean lowerNeedInvoice;
    @Schema(description = "是否需要单据")
    private Boolean isDocument;
    @Schema(description = "结算策略")
    private SettleStrategyEnum settleStrategy;
    @Schema(description = "货物运费结算方式")
    private Integer settleType;
    @Schema(description = "结算方式枚举")
    private SettleTypeEnum settleTypeEnum;


    @Schema(description = "损耗")
    private BigDecimal loss;
    @Schema(description = "损耗单位(‰/kG)")
    private PriceUnitEnum lossUnit;


    @Schema(description = "结算周期")
    private String billingCycle;
    @Schema(description = "预计收款日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime receivableTime;
    @Schema(description = "预计付款日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime payTime;



    @Schema(description = "装货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime loadDate;
    @Schema(description = "收货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime unloadDate;

    @Schema(description = "装货地址详情")
    private String loadAddressDetail;
    @Schema(description = "卸货地址详情")
    private String unLoadAddressDetail;
    @Schema(description = "装货地省名称")
    private String sendProvinceName;
    @Schema(description = "装货地市名称")
    private String sendCityName;
    @Schema(description = "卸货地省名称")
    private String receiveProvinceName;
    @Schema(description = "卸货地市名称")
    private String receiveCityName;


    @Schema(description = "运输距离")
    private BigDecimal transportDistance;


    @Schema(description = "联系人姓名")
    private String contactName;
    @Schema(description = "联系人电话")
    private String contactMobile;

    @Schema(description = "货源名称")
    private String mediumName;
    @Schema(description = "货物级别id（逗号隔开）", example = "22816")
    private String goodsLevelId;
    @Schema(description = "货物级别名称")
    private String goodsLevel;
    @Schema(description = "货物重量")
    private BigDecimal weight;


    // 安全要求
    @Schema(description = "货物安全")
    private String cargoSecurity;
    @Schema(description = "罐体安全")
    private String tankSecurity;
    @Schema(description = "进出厂安全")
    private String factorySecurity;

    // 运力要求
    @Schema(description = "车辆类型")
    private String mergedField;
    @Schema(description = "车辆载重")
    private BigDecimal carWeight;
    @Schema(description = "排放标准")
    private String emissionStandard;
    @Schema(description = "可装介质")
    private String allowMedium;
    @Schema(description = "是否保温")
    private Boolean isWarm;
    @Schema(description = "是否加热")
    private Boolean isHeat;
    @Schema(description = "上次装货产品")
    private String lastMediumName;

    // 当前登录人相关信息
    @Schema(description = "用户车辆最大载重")
    private BigDecimal carMaxwgt;
    @Schema(description = "车牌号")
    private String carNumber;
    @Schema(description = "司机id")
    private Long driverId;
    @Schema(description = "车辆id")
    private Long carId;



    public void handleData() {
        this.settleTypeEnum = SettleTypeEnum.instanceOf(this.settleType);
    }
}
