package org.example.weiyuntong.billInvoiceaply.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BillWaybillSourcePageResVO {

    // 运单ID
    private Long id;
    // 运单编号
    private String waybillNo; 
    // 待开票金额
    private BigDecimal toPayAmount;
    // 车牌号
    private String carNumber;
    // 装货日期
    private LocalDateTime loadTime;
    // 卸货日期
    private LocalDateTime unloadTime;
    // 装货地
    private String loadAddress;
    // 卸货地
    private String unloadAddress;
    // 货物名称
    private String mediumName;
    // 装货重量
    private BigDecimal loadedWeight;
    // 卸货重量
    private BigDecimal unloadedWeight;
    // 应收金额
    private BigDecimal payableAmount;
    //本次开票金额
    private BigDecimal allotmentMoney;
    // 负责人
    private String creatorName;
    // 创建时间
    private LocalDateTime createTime;

}
