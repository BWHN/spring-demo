package org.example.weiyuntong.abnormalorderfollow.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 委托失效记录跟进记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AbnormalOrderFollowBaseVO {

    @Schema(description = "编码")
    private String code;

    @Schema(description = "关联的id", example = "9256")
    private Long associatedId;

    @Schema(description = "异常记录id")
    private Long abnormalId;

    @Schema(description = "跟进方式")
    private String followMethod;

    @Schema(description = "跟进时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime followTime;

    @Schema(description = "业务需求")
    private String businessRequirements;

    @Schema(description = "开发计划")
    private String developPlan;

    @Schema(description = "备注", example = "跟进说明")
    private String remark;

    @Schema(description = "状态", example = "1")
    private int status;

}
