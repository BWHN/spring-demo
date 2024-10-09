package org.example.weiyuntong.billinvoiceregister.vo;

import com.weiyuntong.module.bizcenter.controller.admin.billInvoiceaply.vo.BillVO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BillInvoiceRegisterDetailVO extends BillInvoiceRegisterBaseVO {

    // id
    private Long id;
    // 申请人
    private String creatorName;
    // 申请时间
    private LocalDateTime createTime;
    // 账单列表
    private List<BillVO> billList;
    // 开票信息
    private List<BillWaybillSourceVO> billWaybillSourceList;

}
