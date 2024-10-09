package org.example.weiyuntong.billinvoiceregister.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import com.weiyuntong.module.bizcenter.controller.admin.billinvoiceregister.enums.BillInvoiceRegisterTypeEnum;
import com.weiyuntong.module.bizcenter.enums.BillRegisterStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BillInvoiceRegisterPageReqVO extends PageParam {

    @Schema(description = "开票编号")
    private String code;
    @Schema(description = "收票/开票")
    private BillInvoiceRegisterTypeEnum type;
    @Schema(description = "状态")
    private BillRegisterStatusEnum status;
    @Schema(description = "发票抬头")
    private String title;
    @Schema(description = "税号")
    private String taxNumber;
    @Schema(description = "账单编号")
    private String billNo;
    @Schema(description = "发票编号")
    private String invoiceNo;
    @Schema(description = "开票人")
    private String invoicer;
    @Schema(description = "开票日期开始")
    private String invoiceTimeStart;
    @Schema(description = "开票日期结束")
    private String invoiceTimeEnd;
    @Schema(description = "登记人")
    private String creatorName;
    @Schema(description = "登记日期开始")
    private String createTimeStart;
    @Schema(description = "登记日期结束")
    private String createTimeEnd;
    @Schema(description = "排序字段 invoice_amount、status、invoice_time、create_time")
    private String customerSort;
    @Schema(description = "正序、倒序 asc desc")
    private String customerSortType;

    private Long entId;

}
