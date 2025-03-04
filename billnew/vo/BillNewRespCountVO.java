package com.weiyuntong.module.bizcenter.controller.admin.billnew.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;


@Schema(description = "管理后台 - 新对账单分页tab统计 Response VO")
@Data
@ToString(callSuper = true)
public class BillNewRespCountVO {

    @Schema(description = "全部")
    private Long allNum;

    @Schema(description = "待提交数量")
    private Long toReconciledServiceNum;

    @Schema(description = "已退回数量")
    private Long backReviewedNum;

    @Schema(description = "待审核数量")
    private Long toReviewedNum;

    @Schema(description = "待内部审核数量")
    private Long toMyReviewedNum;
    @Schema(description = "待对方审核数量")
    private Long toOtherReviewedNum;

    @Schema(description = "待开/收票数量")
    private Long toInvoicedNum;

    @Schema(description = "待收/付款数量")
    private Long toPaidNum;

    @Schema(description = "已完结数量")
    private Long finishedNum;

    @Schema(description = "已作废数量")
    private Long invalidNum;


}
