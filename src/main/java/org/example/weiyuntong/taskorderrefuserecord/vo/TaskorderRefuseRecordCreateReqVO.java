package org.example.weiyuntong.taskorderrefuserecord.vo;

import com.weiyuntong.module.system.enums.EnterpriseTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;
import java.util.Collection;

@Schema(description = "管理后台 - 任务单拒绝记录信息创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TaskorderRefuseRecordCreateReqVO extends TaskorderRefuseRecordBaseVO {
    @Schema(description = "ids")
    private Collection<Long> ids;

    @Schema(description = "企业类型")
    private EnterpriseTypeEnum entType;
}
