package org.example.weiyuntong.bizexpensetype.vo;

import com.weiyuntong.module.bizcenter.enums.ImprestStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
* 费用类型 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BizExpenseTypeBaseVO {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "编码")
    private String code;

    @Schema(description = "费用类型名称", example = "燃油费")
    private String name;

    @Schema(description = "费用上限:0.无上限1.有上限")
    private Boolean isExpenseLimit;

    @Schema(description = "费用上线金额")
    private BigDecimal expenseLimitAmount;

    @Schema(description = "备注", example = "请输入该费用类型的说明")
    private String remark;

    @Schema(description = "版本号")
    private Integer version;

    @Schema(description = "0：不可用；1：可用")
    private Integer status;

    @Schema(description = "费用类型是否启用备用金:启用:ENABLE，停用:Disable")
    private ImprestStatusEnum imprestStatus =ImprestStatusEnum.ENABLE;
}
