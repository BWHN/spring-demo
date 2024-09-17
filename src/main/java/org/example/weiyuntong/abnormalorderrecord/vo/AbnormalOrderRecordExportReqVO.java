package org.example.weiyuntong.abnormalorderrecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "运营中心-异常管理 - 委托失效记录 Excel 导出 Request VO，参数和 AbnormalOrderRecordPageReqVO 是一致的")
@Data
public class AbnormalOrderRecordExportReqVO {

    @Schema(description = "编码")
    private String code;

    @Schema(description = "关联的id", example = "10066")
    private Long associatedId;

    @Schema(description = "类型", example = "1")
    private String type;

    @Schema(description = "备注信息", example = "随便")
    private String remark;

    @Schema(description = "处理状态:已处理、未处理", example = "1")
    private String status;

    @Schema(description = "记录最后的状态", example = "2")
    private String finalStatus;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
