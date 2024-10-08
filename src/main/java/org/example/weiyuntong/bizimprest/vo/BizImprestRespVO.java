package org.example.weiyuntong.bizimprest.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 备用金信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BizImprestRespVO extends BizImprestBaseVO {

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
