package org.example.weiyuntong.transporttaskmatch.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "业务中心 - 运输任务匹配信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TransportTaskMatchRespVO extends TransportTaskMatchBaseVO {

    @Schema(description = "id", required = true, example = "13973")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
