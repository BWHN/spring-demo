package org.example.weiyuntong.billpayapply.vo;

import com.weiyuntong.module.bizcenter.enums.BillApplyStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
* 付款申请 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BillPayApplyBaseVO {

    @Schema(description = "公司ID", example = "30705")
    private Long entId;

    @Schema(description = "客户ID", example = "15832")
    private Long customerId;

    @Schema(description = "客户名称")
    private String customer;

    @Schema(description = "申请编号")
    private String code;

    @Schema(description = "状态")
    private BillApplyStatusEnum status;

    @Schema(description = "付款方式 ")
    private Integer payWay;

    @Schema(description = "付款金额")
    private BigDecimal payAmount  = BigDecimal.ZERO;

    @Schema(description = "收款方账户信息id", example = "32442")
    private Long bankAccountId;

    @Schema(description = "收款账号")
    private String payeeAccountNumber;

    @Schema(description = "收款账户")
    private String payeeAccountName;

    @Schema(description = "收款开户行")
    private String payeeOpeningBankName;

    @Schema(description = "期望付款时间")
    private LocalDateTime expectPayTime;

    @Schema(description = "部门id", example = "25667")
    private Long deptId;

}
