package org.example.weiyuntong.credit.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - 客户赊销分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CustomerCreditPageReqVO extends PageParam {

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
