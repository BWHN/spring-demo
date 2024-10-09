package org.example.weiyuntong.billinvoiceregister.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BillWaybillSourceVO {
    
    // 账单ID
    private Long billId;
    // 账单号
    private String billNo;
    // 运单ID
    private Long waybillSourceId;
    // 运单号
    private String waybillNo;
    // 本单核销金额
    private BigDecimal allotmentMoney;
    // 车牌号
    private String carNumber;
    // 实际装货时间
    private LocalDateTime realLoadedTime;
    // 实际卸货时间
    private LocalDateTime realUnloadedTime;
    // 装货地
    private String loadAddress;
    // 卸货地
    private String unloadAddress;
    // 货物名称
    private String mediumName;
    // 装货吨数
    private BigDecimal loadedWeight;
    // 卸货吨数
    private BigDecimal unloadedWeight;
    // 应收金额
    private BigDecimal amount;
    // 负责人
    private String creatorName;
    // 创建时间
    private LocalDateTime createTime;
    
}
