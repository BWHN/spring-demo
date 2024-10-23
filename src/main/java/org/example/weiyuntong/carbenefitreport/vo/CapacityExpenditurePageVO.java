package org.example.weiyuntong.carbenefitreport.vo;

import com.weiyuntong.module.datacenter.controller.admin.export.annotations.ExportParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 运力支出
 */

@Data
public class CapacityExpenditurePageVO {

    @ExportParam(parent = "月份", value = "月份")
    @Schema(description = "月份")
    private String cycle;

    @ExportParam(parent = "承运人", value = "承运人")
    @Schema(description = "承运人")
    private String carrier;

    @ExportParam(parent = "运力类型", value = "运力类型")
    @Schema(description = "运力类型 -> 常规运力和散车运力")
    private String carrierType;

    @ExportParam(parent = "是否认证", value = "是否认证")
    @Schema(description = "是否认证")
    private String authentication;

    @ExportParam(parent = "车源负责人", value = "车源负责人")
    @Schema(description = "车源负责人-姓名")
    private String carCorporateName;



    @ExportParam(parent = "业务", value = "车次数")
    @Schema(description = "车次数")
    private Integer waybillCarNum;

    @ExportParam(parent = "业务", value = "运量总数（吨）")
    @Schema(description = "运量总（吨）")
    private BigDecimal shippingWeight;

    @ExportParam(parent = "业务", value = "重车里程（公里）")
    @Schema(description = "重车里程（公里）")
    private BigDecimal loadedMileage;


    @ExportParam(parent = "业务", value = "重车单价（元/吨/公里）")
    @Schema(description = "重车单价（元/吨/公里）")
    private BigDecimal loadedUnitPrice;


    @ExportParam(parent = "利润", value = "业务利润（元）")
    @Schema(description = "业务利润（元）")
    private BigDecimal realWaybillCarProfit;

    @ExportParam(parent = "利润", value = "业务利润率")
    @Schema(description = "业务利润率")
    private BigDecimal realWaybillCarProfitRate;



    @ExportParam(parent = "支出", value = "应付金额（元）")
    @Schema(description = "应付金额（元）")
    private BigDecimal receivablesAmount;

    @ExportParam(parent = "支出", value = "已付金额（元）")
    @Schema(description = "已付金额（元）")
    private BigDecimal realReceivablesAmount;

    @ExportParam(parent = "支出", value = "未付金额（元）")
    @Schema(description = "未付金额（元）")
    private BigDecimal unpaidAmount;

    @Schema(description = "忽略金额(元)")
    @ExportParam(parent = "支出", value = "忽略金额(元)")
    private BigDecimal ignoreAmount;



    @ExportParam(parent = "成本", value = "总成本（元）")
    @Schema(description = "总成本（元）")
    private BigDecimal totalCost;

    @ExportParam(parent = "成本", value = "垫付成本（元）")
    @Schema(description = "垫付成本（元）")
    private BigDecimal dianfuCost;



}
