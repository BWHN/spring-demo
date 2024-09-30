package org.example.weiyuntong.bizimprest.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
* 备用金信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BizImprestBaseVO {

    @Schema(description = "编码")
    private String code;

    @Schema(description = "备用金金额")
    private BigDecimal imprestAmount;

    @Schema(description = "备注", example = "备用金说明")
    private String remark;

    @Schema(description = "版本号")
    private Integer version;

    @Schema(description = "上升或下降：0.未变化 1.上升2.下降")
    private Integer flag;
}
