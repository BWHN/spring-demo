package com.weiyuntong.module.bizcenter.controller.admin.billnew.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;


@Schema(description = "管理后台 - 新对账单分页tab统计 Response VO")
@Data
@ToString(callSuper = true)
public class OutBillNewRespCountVO {

    @Schema(description = "全部")
    private Long allNum;
    @Schema(description = "可申请")
    private Long canApplyNum;
    @Schema(description = "申请中")
    private Long applyingNum;
    @Schema(description = "已开票")
    private Long invoicedNum;

}
