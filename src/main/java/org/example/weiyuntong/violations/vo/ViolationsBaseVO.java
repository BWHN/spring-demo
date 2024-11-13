package org.example.weiyuntong.violations.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 违规管理 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ViolationsBaseVO {

    @Schema(description = "id", required = true, example = "6166")
    private Long id;

    @Schema(description = "车队名称", example = "李四")
    private String fleetName;

    @Schema(description = "违规时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime violationTime;

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

    @Schema(description = "创建者姓名")
    private String creatorName;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    /**
     * 公司通报原因
     */
    private String notificationReason;
    /**
     * 司机名称
     */
    private String driverName;
    /**
     * 押运员名称
     */
    private String followName;
}
