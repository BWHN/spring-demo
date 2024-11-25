package org.example.weiyuntong.transportorder.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillTypeEnum;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import com.weiyuntong.module.bizcenter.enums.SettleStrategyEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * @author FanluNiu
 * @version 1.0
 * @date 2024-08-06 14:10
 */
@Data
public class TaskOrderCapacityVO {


    private Long id;

    @Schema(description = "结算公司id")
    private Long carrierId;

    @Schema(description = "结算公司名称")
    private String carrierName;

    @Schema(description = "承运商id")
    private Long capacityId;

    @Schema(description = "承运商")
    private String capacityName;

    @Schema(description = "任务单ASSIGN/委托单ENTRUST")
    private WaybillTypeEnum type;

    @Schema(description = "车辆id")
    private Long carId;

    @Schema(description = "车牌号")
    private String carNumber;

    @Schema(description = "寻车运价")
    private BigDecimal searchCarPrice;

    @Schema(description = "寻车运价单位：元/吨、元/升、元/KG等")
    private PriceUnitEnum searchCarPriceUnit;

    @Schema(description = "重量")
    private BigDecimal weight;

    @Schema(description = "下游是否需要开票")
    private Boolean lowerNeedInvoice;

    @Schema(description = "是否需要单据")
    private Boolean isDocument;

    @Schema(description = "装货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime loadDate;

    @Schema(description = "收货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime unloadDate;

    @Schema(description = "接单方预计毛利润")
    private BigDecimal grossProfit;

    @Schema(description = "发起方预计毛利润")
    private BigDecimal startGrossProfit;

    @Schema(description = "结算策略")
    private SettleStrategyEnum settleStrategy;

    @Schema(description = "货物运费结算方式（settl_type运输单价*卸货量/运输单价*装货量/总报价）")
    private Integer settleType;

    @Schema(description = "损耗")
    private BigDecimal loss;

    @Schema(description = "损耗单位(‰/kG)")
    private PriceUnitEnum lossUnit;

    @Schema(description = "付款时间")
    private LocalDateTime payTime;

    @Schema(description = "是否允许报不同价格")
    private Boolean isQuotePrice;

    @Schema(description = "查看权限:DEFAULT_ALL默认全部可见,VISIBLE_TO_SPECIFIC_CARRIERS部分承运商可见，FOR_INTERNAL_ENTERPRISE公司内部可见")
    private String viewPermissions;

    @Schema(description = "查看的权限的承运商id，逗号分隔")
    private String viewPermissionsCarrier;

    @Schema(description = "可见范围名称")
    private String viewPermissionsName;

}
