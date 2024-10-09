package org.example.weiyuntong.billinvoiceregister.vo;

import lombok.Data;

@Data
public class BillInvoiceRegisterPageSummaryVO {

    // 全部
    private long total;
    // 待核销
    private long toChecked;
    // 部分核销
    private long partChecked;
    // 已核销
    private long checked;
    // 已作废
    private long aborted;

}
