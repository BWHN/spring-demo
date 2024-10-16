package org.example.weiyuntong.billpayapply.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BillPayApplyRegisterReqVO extends BillPayApplyBaseVO {

    // 申请ID
    private Long id;
    // 付款凭证
    private String payUrl;
    // 付款凭证金额
    private BigDecimal payUrlAmount;
    // 付款时间
    private LocalDateTime payTime;
    // 付款账号
    private String payerAccountNumber;
    // 付款账户
    private String payerAccountName;
    // 付款开户行
    private String payerOpeningBankName;
    // 账单信息
    private List<BillInfo> billInfoList;

    @Data
    public static class BillInfo {
        // 账单id
        private Long id;
        // 是否忽略
        private Integer ignored;
    }

}
