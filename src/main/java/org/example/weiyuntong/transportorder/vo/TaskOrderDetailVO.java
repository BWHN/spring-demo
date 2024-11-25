package org.example.weiyuntong.transportorder.vo;

import cn.hutool.core.util.StrUtil;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallgoodssource.vo.tradehall.TradeHallOrderProcessVO;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallgoodssource.vo.tradehall.TradeHallOrderWaybillCarVO;
import com.weiyuntong.module.bizcenter.dal.dataobject.tradehallprocess.TradehallProcessDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.transporttaskentrustorder.TransportTaskEntrustorderDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillTypeEnum;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import com.weiyuntong.module.bizcenter.enums.SettleStrategyEnum;
import com.weiyuntong.module.bizcenter.enums.SettleTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "接单详情 Response VO")
@Data
@ToString(callSuper = true)
public class TaskOrderDetailVO {

    @Schema(description = "预测里程")
    private BigDecimal transportDistance;
    @Schema(description = "预测时长")
    private BigDecimal transportTime;
    @Schema(description = "订单编号")
    private String code;
    @Schema(description = "装货地址详情")
    private String loadAddressDetail;
    @Schema(description = "装货地址名称")
    private String loadAddressName;
    @Schema(description = "卸货地址详情")
    private String unLoadAddressDetail;
    @Schema(description = "卸货地址名称")
    private String unLoadAddressName;
    /********************************************** 托运信息 *******************************************/
    @Schema(description = "计划id")
    private Long planId;
    @Schema(description = "计划Code")
    private String taskCode;
    @Schema(description = "托运人")
    private String consignor;
    @Schema(description = "货物名称")
    private String mediumName;
    @Schema(description = "货物级别id（逗号隔开）", example = "22816")
    private String goodsLevelId;
    @Schema(description = "货物级别名称")
    private String goodsLevel;
    @Schema(description = "货物重量")
    private BigDecimal weight;
    @Schema(description = "货物重量单位")
    private PriceUnitEnum unit;
    @Schema(description = "装货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime beginDate;
    @Schema(description = "收货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endDate;
    @Schema(description = "合同编码")
    private String contractCode;
    @Schema(description = "联系人")
    private String supplyContacts;
    @Schema(description = "联系人电话")
    private String supplyContactsPhone;
    /********************************************** 货物总量 *******************************************/
    @Schema(description = "已送达")
    private BigDecimal deliveredWeight;
    @Schema(description = "待卸货")
    private BigDecimal toUnloadedWeight;
    @Schema(description = "待装货")
    private BigDecimal toLoadedWeight;
    @Schema(description = "待发车")
    private BigDecimal toDepartedWeight;
    @Schema(description = "已撤销")
    private BigDecimal revokedWeight;
    @Schema(description = "已放弃")
    private BigDecimal refusedWeight;
    @Schema(description = "剩余")
    private BigDecimal remainingWeight;
    @Schema(description = "待下发")
    private BigDecimal toIssuedWeight;
    /********************************************** 运输要求 *******************************************/
    @Schema(description = "委托运价")
    private BigDecimal entrustPrice;
    @Schema(description = "委托运价单位")
    private PriceUnitEnum entrustPriceUnit;
    @Schema(description = "结算策略")
    private SettleStrategyEnum settleStrategy;
    @Schema(description = "合理损耗")
    private BigDecimal loss;
    @Schema(description = "合理损耗单位")
    private PriceUnitEnum lossUnit;
    @Schema(description = "结算周期")
    private String billingCycle;
    @Schema(description = "结算方式")
    private Integer settleType;
    @Schema(description = "结算方式枚举")
    private SettleTypeEnum settleTypeEnum;
    @Schema(description = "是否开票")
    private Boolean lowerNeedInvoice;
    @Schema(description = "是否需要单据")
    private Boolean isDocument;
    @Schema(description = "货物安全")
    private String cargoSecurity;
    @Schema(description = "罐体安全")
    private String tankSecurity;
    @Schema(description = "进出厂安全")
    private String factorySecurity;
    @Schema(description = "车辆类型")
    private String mergedField;
    @Schema(description = "车辆载重")
    private BigDecimal carWeight;
    @Schema(description = "上次装货产品")
    private String lastMediumName;
    @Schema(description = "排放标准")
    private String emissionStandard;
    @Schema(description = "可装介质")
    private String allowMedium;
    @Schema(description = "是否保温")
    private Boolean isWarm;
    @Schema(description = "是否加热")
    private Boolean isHeat;

     /********************************************** 客户结算要求 *******************************************/
    @Schema(description = "结算策略")
    private SettleStrategyEnum customerSettleStrategy;
    @Schema(description = "损耗")
    private BigDecimal customerLoss;
    @Schema(description = "损耗单位(‰/kG)")
    private PriceUnitEnum customerLossUnit;
    @Schema(description = "上游结算周期")
    private String customerBillingCycle;
    @Schema(description = "结算方式", example = "2")
    private Integer customerSettleType;
    @Schema(description = "是否开票")
    private Boolean customerNeedInvoice;
    @Schema(description = "是否需要单据")
    private Boolean customerIsDocument;
    @Schema(description = "客户价格")
    private BigDecimal customerPrice;
    @Schema(description = "客户价格单位")
    private PriceUnitEnum customerPriceUnit;
    /********************************************** 匹配运力 *******************************************/
    @Schema(description = "运单单类型")
    private WaybillTypeEnum type;
    @Schema(description = "承运人")
    private String carriers;
    @Schema(description = "是否允许报不同价格")
    private Boolean isQuotePrice;
    @Schema(description = "待确认报价信息")
    private List<TradeHallOrderProcessVO> toSureProcessInfoList;
    @Schema(description = "已确认报价信息")
    private List<TradeHallOrderProcessVO> sureProcessInfoList;
    @Schema(description = "被拒绝报价信息")
    private List<TradeHallOrderProcessVO> refusedProcessInfoList;
    @Schema(description = "被撤销报价信息")
    private List<TradeHallOrderProcessVO> revokedProcessInfoList;
    /********************************************** 运单列表 *******************************************/
    @Schema(description = "待下发运单信息")
    private List<TradeHallOrderWaybillCarVO> toIssuedWaybilCarList;
    @Schema(description = "待发车运单信息")
    private List<TradeHallOrderWaybillCarVO> toDepartedWaybilCarList;
    @Schema(description = "待装货运单信息")
    private List<TradeHallOrderWaybillCarVO> toLoadedWaybilCarList;
    @Schema(description = "待卸货运单信息")
    private List<TradeHallOrderWaybillCarVO> toUnloadedWaybilCarList;
    @Schema(description = "待核对运单信息")
    private List<TradeHallOrderWaybillCarVO> toCheckedWaybilCarList;
    @Schema(description = "已完结运单信息")
    private List<TradeHallOrderWaybillCarVO> finishedWaybilCarList;

    // 是否发单人
    private Integer isSender;

    public void handleData(TransportTaskEntrustorderDO entrustOrderDO, List<TradehallProcessDO> processList) {
        this.type = entrustOrderDO.getType();
        this.carriers = processList.stream().map(TradehallProcessDO::getCapacityName).filter(StrUtil::isNotEmpty).distinct().collect(Collectors.joining(","));
        this.settleTypeEnum = SettleTypeEnum.instanceOf(this.settleType);
        if (this.transportDistance != null) {
            this.transportTime = this.transportDistance.divide(new BigDecimal("80"), 1, RoundingMode.HALF_UP);
        }
    }

}
