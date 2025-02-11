package org.example.weiyuntong.tradehallgoodssource.vo.tradehall;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillTypeEnum;
import com.weiyuntong.module.bizcenter.enums.GoodsViewPermissionsEnums;
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

@Schema(description = "我要接单 Response VO")
@Data
@ToString(callSuper = true)
public class TradeHallOrderTakeVO {

    @Schema(description = "已分配")
    private BigDecimal distributedWeight = BigDecimal.ZERO;
    @Schema(description = "待分配")
    private BigDecimal toDistributeWeight = BigDecimal.ZERO;
    @Schema(description = "被撤销")
    private BigDecimal revokedWeight = BigDecimal.ZERO;
    @Schema(description = "已放弃")
    private BigDecimal refusedWeight = BigDecimal.ZERO;
    @Schema(description = "已确认")
    private BigDecimal dealWeight = BigDecimal.ZERO;
    @Schema(description = "剩余重量")
    private BigDecimal remainingWeight = BigDecimal.ZERO;


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
    @Schema(description = "装货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime loadDate;
    @Schema(description = "收货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime unloadDate;
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
    @Schema(description = "是否允许报不同价格1.是，0不是")
    private Boolean isQuotePrice;
    @Schema(description = "寻车运价")
    private BigDecimal searchCarPrice;
    @Schema(description = "寻车运价单位：元/吨、元/升、元/KG等")
    private PriceUnitEnum searchCarPriceUnit;
    @Schema(description = "运单单类型")
    private WaybillTypeEnum type;

    @Schema(description = "下游是否需要开票")
    private Boolean lowerNeedInvoice;
    @Schema(description = "是否需要单据")
    private Boolean isDocument;
    @Schema(description = "结算策略")
    private SettleStrategyEnum settleStrategy;
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
    @Schema(description = "货物运费结算方式")
    private Integer settleType;
    @Schema(description = "结算方式枚举")
    private SettleTypeEnum settleTypeEnum;
    @Schema(description = "运输距离")
    private BigDecimal transportDistance;
    @Schema(description = "待提交报价信息")
    private List<TradeHallOrderProcessVO> toSubmitProcessInfoList;
    @Schema(description = "待确认报价信息")
    private List<TradeHallOrderProcessVO> toSureProcessInfoList;
    @Schema(description = "已确认报价信息")
    private List<TradeHallOrderProcessVO> sureProcessInfoList;
    @Schema(description = "被拒绝报价信息")
    private List<TradeHallOrderProcessVO> refusedProcessInfoList;
    @Schema(description = "被撤销报价信息")
    private List<TradeHallOrderProcessVO> revokedProcessInfoList;
    @Schema(description = "待提交补充信息——平台业务")
    private List<TradeHallOrderProcessExtraVO> toSubmitProcessInfoExtraList;
    // 发单方撤销量
    @JsonIgnore
    private BigDecimal senderRevokedWeight;
    // 撤销接单方的重量
    @JsonIgnore
    private BigDecimal revokeReceiveWeight;
    // 可见范围
    @JsonIgnore
    private GoodsViewPermissionsEnums viewPermissions;
    // 可见范围
    @JsonIgnore
    private Integer senderFlag;
    // 是否托运人
    private Boolean isTop;

    public void handleData() {
        this.settleTypeEnum = SettleTypeEnum.instanceOf(this.settleType);
    }
}
