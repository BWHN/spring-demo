package org.example.weiyuntong.updatelog.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 修改记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UpdateLogPageReqVO extends PageParam {

    @Schema(description = "关联id", example = "7078")
    private Long linkId;

    @Schema(description = "修改项")
    private String updateModified;

    @Schema(description = "修改节点")
    private String updateNode;

    @Schema(description = "修改前")
    private String beforeContent;

    @Schema(description = "修改后")
    private String endContent;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
