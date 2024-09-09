package org.example.weiyuntong.bill.vo;

import com.weiyuntong.module.bizcenter.controller.admin.billinvoice.vo.BillInvoicePostVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class BillInvoiceLinkVO {

    @Schema(description = "账单列表数据")
    private List<BillInvoicePageVO> billList;

    @Schema(description = "发票数据")
    private BillInvoicePostVO Invoice;

}
