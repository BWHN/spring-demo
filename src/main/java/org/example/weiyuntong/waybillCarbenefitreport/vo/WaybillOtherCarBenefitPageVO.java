package org.example.weiyuntong.waybillCarbenefitreport.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillStatusEnum;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import com.weiyuntong.module.datacenter.controller.admin.export.annotations.ExportParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class WaybillOtherCarBenefitPageVO {

    @ExportParam(parent = "运单编码", value = "运单编码")
    private String waybillSourceNo;
    @ExportParam(parent = "车次编码", value = "车次编码")
    private String waybillCarNo;
    @ExportParam(parent = "车次类型", value = "车次类型")
    private String waybillCarType;
    @ExportParam(parent = "车次状态", value = "车次状态")
    private WaybillStatusEnum waybillCarStatus;
    @ExportParam(parent = "发车时间", value = "发车时间")
    private LocalDateTime departedTime;
    @ExportParam(parent = "装货时间", value = "装货时间")
    private LocalDateTime loadedTime;
    @ExportParam(parent = "卸货时间", value = "卸货时间")
    private LocalDateTime unloadedTime;
    @ExportParam(parent = "运行天数", value = "运行天数")
    private BigDecimal runDays;
    @ExportParam(parent = "装货城市", value = "装货城市")
    private String loadedCity;
    @ExportParam(parent = "卸货城市", value = "卸货城市")
    private String unloadedCity;
    @ExportParam(parent = "重车里程(公里)", value = "重车里程(公里)")
    private BigDecimal loadedMileage;
    @ExportParam(parent = "空车里程(公里)", value = "空车里程(公里)")
    private BigDecimal emptyMileage;
    @ExportParam(parent = "车牌号", value = "车牌号")
    private String carNumber;
    @ExportParam(parent = "货物名称", value = "货物名称")
    private String goodsName;
    @ExportParam(parent = "装货重量(吨)", value = "装货重量(吨)")
    private BigDecimal loadedWeight;
    @ExportParam(parent = "卸货重量(吨)", value = "卸货重量(吨)")
    private BigDecimal unloadedWeight;

    @ExportParam(parent = "利润", value = "预测业务利润(元)")
    private BigDecimal predictProfit;
    @ExportParam(parent = "利润", value = "实际业务利润(元)")
    private BigDecimal realProfit;
    @ExportParam(parent = "利润", value = "利润率")
    private BigDecimal realProfitRate;

    @ExportParam(parent = "收入", value = "应收金额(元)")
    private BigDecimal receivableAmount;
    @ExportParam(parent = "收入", value = "实际收款金额(元)")
    private BigDecimal receivedAmount;
    @ExportParam(parent = "收入", value = "未收金额(元)")
    private BigDecimal receiveRemainingAmount;
    @Schema(description = "忽略金额(元)")
    @ExportParam(parent = "收入", value = "忽略收款金额(元)")
    private BigDecimal ignoreReceivableAmount;

    @ExportParam(parent = "支出", value = "应付金额(元)")
    private BigDecimal payableAmount;
    @ExportParam(parent = "支出", value = "实际付款金额(元)")
    private BigDecimal paidAmount;
    @ExportParam(parent = "支出", value = "未付金额(元)")
    private BigDecimal payRemainingAmount;
    @Schema(description = "忽略金额(元)")
    @ExportParam(parent = "支出", value = "忽略付款金额(元)")
    private BigDecimal ignorePayableAmount;

    @ExportParam(parent = "成本", value = "总成本(元)")
    private BigDecimal totalCost;
    @ExportParam(parent = "成本", value = "自身成本(元)")
    private BigDecimal ownCost;
    @ExportParam(parent = "成本", value = "承兑成本(元)")
    private BigDecimal settleCost;
    @ExportParam(parent = "成本", value = "垫付成本(元)")
    private BigDecimal advanceCost;

    @ExportParam(parent = "应收账单", value = "应收账单编码")
    private String receiveBillNo;
    @ExportParam(parent = "应收账单", value = "应收账单创建时间")
    private LocalDateTime receiveBillCreateTime;
    @ExportParam(parent = "应收账单", value = "应收账单创建人")
    private String receiveBillCreator;
    @ExportParam(parent = "应收账单", value = "应收账单状态")
    private BillStatusEnum receiveBillStatus;
    @ExportParam(parent = "应收账单", value = "托运人")
    private String consignor;
    @ExportParam(parent = "应收账单", value = "货源业务员")
    private String goodsServiceName;
    @ExportParam(parent = "应收账单", value = "发单人")
    private String waybillSender;
    @ExportParam(parent = "应收账单", value = "委托运价")
    private BigDecimal entrustPrice;
    @ExportParam(parent = "应收账单", value = "运价单位")
    private PriceUnitEnum entrustPriceUnit;
    @ExportParam(parent = "应收账单", value = "上游是否开票")
    private Boolean upperNeedInvoice;
    @ExportParam(parent = "应收账单", value = "上游货物损耗(元)")
    private BigDecimal upperLossAmount;
    @ExportParam(parent = "应收账单", value = "扣款金额(元)")
    private BigDecimal receiveDeductAmount;
    @ExportParam(parent = "应收账单", value = "补偿金额(元)")
    private BigDecimal receiveCompensateAmount;

    @ExportParam(parent = "应付账单", value = "应付账单编码")
    private String payBillNo;
    @ExportParam(parent = "应付账单", value = "应付账单创建时间")
    private LocalDateTime payBillCreateTime;
    @ExportParam(parent = "应付账单", value = "应付账单创建人")
    private String payBillCreator;
    @ExportParam(parent = "应付账单", value = "应付账单状态")
    private BillStatusEnum payBillStatus;
    @ExportParam(parent = "应付账单", value = "承运人")
    private String carrier;
    @ExportParam(parent = "应付账单", value = "车源业务员")
    private String carServiceName;
    @ExportParam(parent = "应付账单", value = "报价人/接单人")
    private String waybillReceiver;
    @ExportParam(parent = "应付账单", value = "实际成交价")
    private BigDecimal dealPrice;
    @ExportParam(parent = "应付账单", value = "运价单位")
    private PriceUnitEnum dealPriceUnit;
    @ExportParam(parent = "应付账单", value = "下游是否开票")
    private Boolean lowerNeedInvoice;
    @ExportParam(parent = "应付账单", value = "下游货物损耗(元)")
    private BigDecimal lowerLossAmount;
    @ExportParam(parent = "应付账单", value = "扣款金额(元)")
    private BigDecimal payDeductAmount;
    @ExportParam(parent = "应付账单", value = "补偿金额(元)")
    private BigDecimal payCompensateAmount;

    @ExportParam(parent = "备注", value = "备注")
    private String remark;

    private BigDecimal receiveWithoutTax;

}
