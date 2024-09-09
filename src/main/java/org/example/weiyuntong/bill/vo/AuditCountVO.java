package org.example.weiyuntong.bill.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AuditCountVO {

    @Schema(description = "全部")
    private Long allNum;

    @Schema(description = "待审核数量")
    private Long toReviewedNum;

    @Schema(description = "已审核数量")
    private Long auditedNum;

    @Schema(description = "已驳回数量")
    private Long backReviewedNum;

}
