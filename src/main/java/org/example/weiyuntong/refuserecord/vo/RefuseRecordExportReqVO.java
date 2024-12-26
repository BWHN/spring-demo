package org.example.weiyuntong.refuserecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 撤销信息记录 Excel 导出 Request VO，参数和 RefuseRecordPageReqVO 是一致的")
@Data
public class RefuseRecordExportReqVO {

    @Schema(description = "拒绝编码")
    private String code;

    @Schema(description = "关联的id", example = "16414")
    private Long associatedId;

    @Schema(description = "拒绝类型:", example = "1")
    private String type;

    @Schema(description = "拒绝原因，支持多选，以逗号分隔", example = "不对")
    private String refuseReason;

    @Schema(description = "备注信息", example = "随便")
    private String remark;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
