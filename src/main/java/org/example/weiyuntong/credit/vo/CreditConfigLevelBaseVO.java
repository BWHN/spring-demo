package org.example.weiyuntong.credit.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
* 赊销评级 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CreditConfigLevelBaseVO {

    @Schema(description = "客户评价")
    private String customerLevel;

    @Schema(description = "承运商", example = "14633")
    private Long carrierId;

    @Schema(description = "授信额度")
    private BigDecimal creditAmount;

}
