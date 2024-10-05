package org.example.weiyuntong.credit.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 赊销评级 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CreditConfigLevelRespVO extends CreditConfigLevelBaseVO {

    @Schema(description = "ID", required = true, example = "17150")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
