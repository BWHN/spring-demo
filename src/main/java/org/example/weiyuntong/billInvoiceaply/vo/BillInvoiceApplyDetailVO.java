package org.example.weiyuntong.billInvoiceaply.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BillInvoiceApplyDetailVO extends BillInvoiceApplyBaseVO {

    // id
    private Long id;
    // 申请人
    private String creatorName;
    // 申请时间
    private LocalDateTime createTime;
    // 账单列表
    private List<BillVO> billList;
    // 退回记录
    private List<BillInvoiceApplyAbortVO> abortList;
    // 开票信息
    private List<BillInvoiceRegisterVO> billInvoiceRegisterList;

}
