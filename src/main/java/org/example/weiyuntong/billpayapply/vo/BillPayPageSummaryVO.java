package org.example.weiyuntong.billpayapply.vo;

import lombok.Data;

@Data
public class BillPayPageSummaryVO {

    // 全部
    private long total;
    // 待提交
    private long toSubmit;
    // 已退回
    private long rejected;
    // 待审核
    private long pendingReview;
    // 待付款
    private long toPay;
    // 已完结
    private long finished;

}
