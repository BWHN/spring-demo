package org.example.weiyuntong.abnormalorderassign.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "运营中心-异常管理 - 委托失效分配记录 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AbnormalOrderAssignRespVO extends AbnormalOrderAssignBaseVO {

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
