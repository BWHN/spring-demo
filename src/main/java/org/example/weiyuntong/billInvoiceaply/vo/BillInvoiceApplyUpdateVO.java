package org.example.weiyuntong.billInvoiceaply.vo;

import lombok.Data;

import java.util.List;

@Data
public class BillInvoiceApplyUpdateVO extends BillInvoiceApplyBaseVO {

    // id
    private Long id;
    // 关联关系
    private List<BillInvoiceApplyRelationCreateVO> billInvoiceApplyRelationList;
    // 是否需要提交
    private boolean needSubmit;
}
