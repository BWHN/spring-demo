package org.example.weiyuntong.billinvoiceregister.vo;

import lombok.Data;

import java.util.List;

@Data
public class BillInvoiceRegisterCreateVO extends BillInvoiceRegisterBaseVO {

    // 账单信息
    private List<BillInvoiceRegisterRelationCreateVO> invoiceRegisterRelationList;

}
