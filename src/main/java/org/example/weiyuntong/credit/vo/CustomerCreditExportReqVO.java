package org.example.weiyuntong.credit.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - 客户赊销 Excel 导出 Request VO，参数和 CustomerCreditPageReqVO 是一致的")
@Data
public class CustomerCreditExportReqVO {

    @Schema(description = "客户名称", example = "李四")
    private String name;

    @Schema(description = "客户评级")
    private String level;

    @Schema(description = "客户状态（1.潜在客户，2.机会客户，3.成单客户，4.优质客户）", example = "2")
    private String status;

    @Schema(description = "账单状态（NOT_OVERDUE: 未逾期, OVERDUE 已逾期）", example = "NOT_OVERDUE")
    private CreditBillStatusEnum billStatus;

    @Schema(description = "承运商ID 可为空，默认取当前企业ID")
    private Long carrierId;

}
