package org.example.weiyuntong.taskorderrefuserecord.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.transporttaskentrustorder.TransportTaskEntrustorderDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 任务单拒绝记录信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TaskorderRefuseRecordRespVO extends TaskorderRefuseRecordBaseVO {

    @Schema(description = "id", required = true, example = "24678")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    private TransportTaskEntrustorderDO transportTaskEntrustorderDO;

}
