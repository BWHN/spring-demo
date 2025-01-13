package org.example.weiyuntong.tradehallcarsource.vo;

import com.weiyuntong.module.bizcenter.enums.VehicleSourcesStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "交易大厅-车源管理 Excel 导出 Request VO，参数和 TradehallCarSourcePageReqVO 是一致的")
@Data
public class TradehallCarSourceExportReqVO {

    @Schema(description = "编码")
    private String code;

    @Schema(description = "租户名称", example = "李四")
    private String tenantName;

    @Schema(description = "起始地省级编码")
    private String startProvinceCode;

    @Schema(description = "起始地市级编码")
    private String startCityCode;

    @Schema(description = "起始地区级编码")
    private String startDistrictCode;

    @Schema(description = "起始地所在省名称", example = "王五")
    private String startProvinceName;

    @Schema(description = "起始地所在市名称", example = "张三")
    private String startCityName;

    @Schema(description = "起始地所在区名称", example = "小有可维")
    private String startDistrictName;

    @Schema(description = "目的地省级编码")
    private String endProvinceCode;

    @Schema(description = "目的地市级别编码")
    private String endCityCode;

    @Schema(description = "目的地区级编码")
    private String endDistrictCode;

    @Schema(description = "目的地所在省名称", example = "王五")
    private String endProvinceName;

    @Schema(description = "目的地地所在市名称", example = "小有可维")
    private String endCityName;

    @Schema(description = "目的地所在区名称", example = "小有可维")
    private String endDistrictName;

    @Schema(description = "空车数量", example = "20726")
    private Integer emptyCarCount;

    @Schema(description = "空车开始日期")
    private LocalDate[] emptyCarStartDate;

    @Schema(description = "空车开始时间：上午、下午、00:00-24:00")
    private String emptyCarStartTime;

    @Schema(description = "空车结束日期")
    private LocalDate[] emptyCarEndDate;

    @Schema(description = "空车结束时间：上午、下午、00:00-24:00")
    private String emptyCarEndTime;

    @Schema(description = "关联车牌号，多车使用逗号分隔")
    private String carIds;

    @Schema(description = "车队名称是否可见，true/false")
    private Boolean isFleetVisible;

    @Schema(description = "车牌号是否可见，true/false")
    private Boolean isCarVisible;

    @Schema(description = "最后一次承运介质名称", example = "张三")
    private String lastMediumName;

    @Schema(description = "车辆载重")
    private BigDecimal carWeight;

    @Schema(description = "允许可装介质，类别之间用逗号分隔")
    private String allowMedium;

    @Schema(description = "排放标准")
    private String emissionStandard;

    @Schema(description = "所需的车辆类型", example = "2")
    private String carType;

    @Schema(description = "是否保温:1.保温")
    private Boolean isWarm;

    @Schema(description = "是否加热:1.加热")
    private Boolean isHeat;

    @Schema(description = "状态:待匹配:UN_MATCHED,待接单:PENDING_ORDER 待下发:WAIT_DISPATCHED,已撤销:TO_CANCELED", example = "1")
    private VehicleSourcesStatusEnum status;

    @Schema(description = "联系人姓名", example = "小有可维")
    private String contactName;

    @Schema(description = "联系人电话")
    private String contactMobile;

    @Schema(description = "排序")
    private Short rowSort;

    @Schema(description = "备注", example = "你猜")
    private String remark;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "版本号")
    private Integer version;

}
