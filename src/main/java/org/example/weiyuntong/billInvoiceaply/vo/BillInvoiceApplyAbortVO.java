package org.example.weiyuntong.billInvoiceaply.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BillInvoiceApplyAbortVO {

    /**
     * 账单id
     */
    private Long applyId;

    /**
     * 驳回人
     */
    private String creatorName;

    /**
     * 驳回时间
     */
    private LocalDateTime abortTime;

    /**
     * 驳回原因
     */
    private String abortReason;


}
