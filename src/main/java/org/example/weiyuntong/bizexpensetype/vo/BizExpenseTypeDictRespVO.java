package org.example.weiyuntong.bizexpensetype.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Schema(description = "管理后台 - 费用类型 Response VO")
@Data
@ToString(callSuper = true)
public class BizExpenseTypeDictRespVO {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "编码")
    private String code;

    @Schema(description = "费用类型名称", example = "燃油费")
    private String name;

    @Schema(description = "默认价格")
    private Double defaultCostValue;

}
