package org.example.weiyuntong.linkrecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 客户关联 Excel 导出 Request VO，参数和 LinkRecordPageReqVO 是一致的")
@Data
public class LinkRecordExportReqVO {

    @Schema(description = "关联货主ID", example = "23583")
    private Long linkId;

    @Schema(description = "关联状态（1.待审核 2.通过审核 3.审核不通过）", example = "1")
    private String status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
