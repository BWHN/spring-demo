package org.example.weiyuntong.billInvoiceaply.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import com.weiyuntong.module.bizcenter.enums.BillApplyStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BillInvoiceApplyPageReqVO extends PageParam {

    @Schema(description = "申请编号")
    private String code;
    @Schema(description = "申请状态")
    private BillApplyStatusEnum status;
    @Schema(description = "账单编号")
    private String billNo;
    @Schema(description = "税号")
    private String taxNumber;
    @Schema(description = "发票抬头")
    private String title;
    @Schema(description = "开票单编号")
    private String registerCode;
    @Schema(description = "申请人")
    private String creatorName;
    @Schema(description = "申请日期开始")
    private String createTimeStart;
    @Schema(description = "申请日期结束")
    private String createTimeEnd;
    @Schema(description = "排序字段 createTime、invoiceAmount")
    private String customOrder;

    private Long entId;
    private Long userId;

}
