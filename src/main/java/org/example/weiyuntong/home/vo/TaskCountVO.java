package org.example.weiyuntong.home.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaskCountVO {

    @Schema(description = "任务单发布重量", example = "32624")
    private BigDecimal assignWeight;

    @Schema(description = "委托单发布重量", example = "32624")
    private BigDecimal entrustWeight;

    @Schema(description = "接单重量", example = "32624")
    private BigDecimal acceptWeight;

    @Schema(description = "企业名称")
    private String entName;

    @Schema(description = "角色名称")
    private String roleName;

}
