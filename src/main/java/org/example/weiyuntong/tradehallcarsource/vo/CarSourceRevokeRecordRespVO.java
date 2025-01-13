package org.example.weiyuntong.tradehallcarsource.vo;

import com.weiyuntong.module.bizcenter.controller.admin.revokerecord.vo.RevokeRecordBaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "车源大厅 - 车源撤销记录信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CarSourceRevokeRecordRespVO extends RevokeRecordBaseVO {

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
