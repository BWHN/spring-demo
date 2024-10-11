package org.example.weiyuntong.billInvoiceaply.vo;

import lombok.Data;

import java.util.List;

@Data
public class BillInvoiceApplyCreateVO extends BillInvoiceApplyBaseVO {

    // 是否需要提交
    private boolean needSubmit;

    private List<BillInvoiceApplyRelationCreateVO> billInvoiceApplyRelationList;

}
