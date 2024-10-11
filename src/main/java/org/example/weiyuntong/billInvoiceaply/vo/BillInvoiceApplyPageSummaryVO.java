package org.example.weiyuntong.billInvoiceaply.vo;

import lombok.Data;

@Data
public class BillInvoiceApplyPageSummaryVO {

    // 全部
    private long total;
    // 待提交
    private long toSubmit;
    // 已退回
    private long rejected;
    // 待审核
    private long pendingReview;
    // 待开票
    private long toInvoiced;
    // 已完结
    private long finished;

}
