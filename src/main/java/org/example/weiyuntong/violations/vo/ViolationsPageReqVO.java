package org.example.weiyuntong.violations.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 违规管理分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ViolationsPageReqVO extends PageParam {

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "车队名称", example = "李四")
    private String fleetName;

    @Schema(description = "违规时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] violationTime;

    /**
     * 车队id
     */
    private Long fleetId;
    /**
     * 处理方法
     */
    private String method;
    /**
     * 违规行为名称
     */
    private String violation;
    /**
     * 车牌号
     */
    private String carNumber;

    /**
     * 类型id
     */
    private Long violationTypeId;
    /**
     * 车辆id
     */
    private Long carId;

    @Schema(description = "驾驶员id", example = "6624")
    private Long driverId;

    @Schema(description = "押运员id", example = "24220")
    private Long followId;

    @Schema(description = "违规类型", example = "2")
    private String type;

    @Schema(description = "审核状态", example = "2")
    private String status;

    @Schema(description = "罚金")
    private BigDecimal money;

    @Schema(description = "备注")
    private String remarks;

    @Schema(description = "视频截图路径")
    private String file;

}
