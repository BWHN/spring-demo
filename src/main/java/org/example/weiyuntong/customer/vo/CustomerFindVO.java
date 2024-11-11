package org.example.weiyuntong.customer.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CustomerFindVO extends PageParam {

    @Schema(description = "客户名称", example = "王五")
    private String customerName;

    @Schema(description = "客户评级")
    private String customerLevel;

    @Schema(description = "客户状态（潜在客户，机会客户，成单客户，优质客户）")
    private String customerState;

    @Schema(description = "客户审核状态（1.待审批 2.已审批 3.转交中 4.正常状态）")
    private String customerCheckStatus;

    @Schema(description = "客户来源（第三方网站，老客户介绍等）")
    private String customerFrom;
}
