package org.example.weiyuntong.favorites.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 收藏夹 Excel 导出 Request VO，参数和 FavoritesPageReqVO 是一致的")
@Data
public class FavoritesExportReqVO {

    @Schema(description = "任务ID", example = "26279")
    private Long taskEntrustOrderId;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
