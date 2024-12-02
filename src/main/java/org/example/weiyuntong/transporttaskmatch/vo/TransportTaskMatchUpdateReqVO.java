package org.example.weiyuntong.transporttaskmatch.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "业务中心 - 运输任务匹配信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TransportTaskMatchUpdateReqVO extends TransportTaskMatchBaseVO {

    @Schema(description = "id", required = true, example = "13973")
    @NotNull(message = "id不能为空")
    private Long id;

}
