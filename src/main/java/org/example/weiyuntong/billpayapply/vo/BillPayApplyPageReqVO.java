package org.example.weiyuntong.billpayapply.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import com.weiyuntong.module.bizcenter.enums.BillApplyStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

@Schema(description = "管理后台 - 付款申请分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillPayApplyPageReqVO extends PageParam {

    @Schema(description = "公司ID", example = "30705")
    private Long entId;

    @Schema(description = "账单编号")
    private String billNo;
    @Schema(description = "客户名称")
    private String customer;
    @Schema(description = "创建人")
    private String creatorName;
    @Schema(description = "申请编号")
    private String code;
    @Schema(description = "状态", example = "2")
    private BillApplyStatusEnum status;
    @Schema(description = "付款方式 ")
    private Integer payWay;
    @Schema(description = "收款方账号")
    private String accountNumber;
    @Schema(description = "收款方账户", example = "王五")
    private String accountName;
    @Schema(description = "开户行")
    private String openBank;
    @Schema(description = "付款方账号")
    private String payAccountNumber;
    @Schema(description = "付款方账户")
    private String payAccountName;
    @Schema(description = "期望付款时间")
    private String expectPayTimeStart;
    private String expectPayTimeEnd;
    @Schema(description = "创建时间")
    private String createTimeStart;
    private String createTimeEnd;

    @Schema(description = "部门id", example = "25667")
    private Long deptId;

    @Schema(description = "前端自定义排序规则")
    private String customOrder;

    public String getCustomOrder(){
        if (StringUtils.isNotBlank(customOrder)){
            if ("payAmount desc".contains(this.customOrder)){
                return customOrder.replace("payAmount", "pay_amount");
            }else if ("createTime desc".contains(this.customOrder)) {
                return customOrder.replace("createTime", "create_time");
            }else if ("expectPayTime desc".contains(this.customOrder)) {
                return customOrder.replace("expectPayTime", "expect_pay_time");
            }else {
                return null;
            }
        }
        return null;
    }

}
