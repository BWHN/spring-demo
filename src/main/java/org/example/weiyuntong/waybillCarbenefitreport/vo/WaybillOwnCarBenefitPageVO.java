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
public class WaybillOwnCarBenefitPageVO {

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
    @ExportParam(parent = "货物损耗(元)", value = "货物损耗(元)")
    private BigDecimal lossAmount;

    @ExportParam(parent = "利润", value = "预测业务利润(元)")
    private BigDecimal predictProfit;
    @ExportParam(parent = "利润", value = "实际业务利润(元)")
    private BigDecimal realProfit;
    @ExportParam(parent = "利润", value = "实际业务利润率")
    private BigDecimal realProfitRate;

    @ExportParam(parent = "收入", value = "应收金额(元)")
    private BigDecimal receivableAmount;
    @ExportParam(parent = "收入", value = "实际收款金额(元)")
    private BigDecimal receivedAmount;
    @ExportParam(parent = "收入", value = "未收金额(元)")
    private BigDecimal receiveRemainingAmount;
    @Schema(description = "忽略金额(元)")
    @ExportParam(parent = "收入", value = "忽略金额(元)")
    private BigDecimal ignoreAmount;

    @ExportParam(parent = "成本", value = "总成本(元)")
    private BigDecimal totalCost;
    @ExportParam(parent = "成本", value = "重车成本(元)")
    private BigDecimal loadedCost;
    @ExportParam(parent = "成本", value = "重车成本占比")
    private BigDecimal loadedCostPercent;
    @ExportParam(parent = "成本", value = "变动成本(元)")
    private BigDecimal changeCost;
    @ExportParam(parent = "成本", value = "变动成本占比")
    private BigDecimal changeCostPercent;
    @ExportParam(parent = "成本", value = "固定成本(元)")
    private BigDecimal fixedAmount;

    @ExportParam(parent = "应收", value = "账单编码")
    private String billNo;
    @ExportParam(parent = "应收", value = "账单创建时间")
    private LocalDateTime billCreateTime;
    @ExportParam(parent = "应收", value = "账单创建人")
    private String billCreator;
    @ExportParam(parent = "应收", value = "账单状态")
    private BillStatusEnum billStatus;
    @ExportParam(parent = "应收", value = "托运人")
    private String consignor;
    @ExportParam(parent = "应收", value = "货源业务员")
    private String goodsServiceName;
    @ExportParam(parent = "应收", value = "发单人")
    private String waybillSender;
    @ExportParam(parent = "应收", value = "委托运价")
    private BigDecimal entrustPrice;
    @ExportParam(parent = "应收", value = "运价单位")
    private PriceUnitEnum entrustPriceUnit;
    @ExportParam(parent = "应收", value = "上游是否开票")
    private Boolean upperNeedInvoice;
    @ExportParam(parent = "应收", value = "扣款金额(元)")
    private BigDecimal deductAmount;
    @ExportParam(parent = "应收", value = "补偿金额(元)")
    private BigDecimal compensateAmount;

    @ExportParam(parent = "变动成本", value = "燃油费用(元)")
    private BigDecimal oilCost;
    @ExportParam(parent = "变动成本", value = "尿素费用(元)")
    private BigDecimal ureaCost;
    @ExportParam(parent = "变动成本", value = "ETC(元)")
    private BigDecimal etcCost;
    @ExportParam(parent = "变动成本", value = "路桥费用(元)")
    private BigDecimal roadBridgeCost;
    @ExportParam(parent = "变动成本", value = "司机提成(元)")
    private BigDecimal driverCost;
    @ExportParam(parent = "变动成本", value = "业务费用(元)")
    private BigDecimal expenseCost;
    @ExportParam(parent = "变动成本", value = "自身成本(元)")
    private BigDecimal ownCost;
    @ExportParam(parent = "变动成本", value = "账期成本(元)")
    private BigDecimal billCycleCost ;
    @ExportParam(parent = "变动成本", value = "承兑成本(元)")
    private BigDecimal settleCost;

    @ExportParam(parent = "备注", value = "备注")
    private String remark;

    private Long waybillCarId;
    private BigDecimal receiveWithoutTax;
    private BigDecimal carCost;
    private BigDecimal maintenanceCost;

}
