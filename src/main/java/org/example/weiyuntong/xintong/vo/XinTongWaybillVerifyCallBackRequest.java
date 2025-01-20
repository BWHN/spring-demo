package org.example.weiyuntong.xintong.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class XinTongWaybillVerifyCallBackRequest {
    // 运单编号
    private String waybillSourceNo;
    // 审核状态
    private Boolean status;
    // 驳回原因
    private String reason;
    // 服务费 成本费用
    private BigDecimal serviceCharge;
}
