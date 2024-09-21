package org.example.weiyuntong.abnormalorderfollow.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "运营中心-异常管理 - 委托失效记录跟进记录 Excel 导出 Request VO，参数和 AbnormalOrderFollowPageReqVO 是一致的")
@Data
public class AbnormalOrderFollowExportReqVO {

    @Schema(description = "编码")
    private String code;

    @Schema(description = "关联的id", example = "9256")
    private Long associatedId;

    @Schema(description = "跟进方式")
    private String followMethod;

    @Schema(description = "跟进时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] followTime;

    @Schema(description = "业务需求")
    private String businessRequirements;

    @Schema(description = "开发计划")
    private String developPlan;

    @Schema(description = "备注", example = "随便")
    private String remark;

    @Schema(description = "状态", example = "1")
    private Byte status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}