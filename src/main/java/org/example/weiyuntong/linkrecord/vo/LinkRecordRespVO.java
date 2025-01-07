package org.example.weiyuntong.linkrecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 客户关联 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LinkRecordRespVO extends LinkRecordBaseVO {

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
