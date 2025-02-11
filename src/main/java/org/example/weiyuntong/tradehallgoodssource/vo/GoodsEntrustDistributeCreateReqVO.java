package org.example.weiyuntong.tradehallgoodssource.vo;

import com.weiyuntong.module.bizcenter.controller.admin.transporttaskentrustorder.vo.TaskDateVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.util.Collection;
import java.util.List;

@Schema(description = "管理后台 - 运输委托单下发记录创建 Request VO")
@Data
@ToString(callSuper = true)
public class GoodsEntrustDistributeCreateReqVO {

    @Schema(description = "路书id", example = "14891")
    private Long lineId;

    @Schema(description = "下发的id", example = "27591")
    private Long id;

    @Schema(description = "前车介质名称", example = "赵六")
    private String lastMediumName;

    @Schema(description = "当前介质名称", example = "王五")
    private String mediumName;

    @Schema(description = "车辆id", example = "21022")
    private Collection<Long> carIds;

    @Schema(description = "车辆对应时间", example = "21022")
    private List<TaskDateVO> taskDateVOS;

    @Schema(description = "是否需要蒸洗罐车1.蒸罐2.洗罐 3.不需要")
    private Integer isRequireSteamPot;

    /*@Schema(description = "运单预计时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime predictWaybillDate;

    @Schema(description = "预计发车日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime predictDepartCarDate;

    @Schema(description = "预计发车时间(小时)")
    private String predictDepartCarTime;

    @Schema(description = "预计装货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime predictLoadDate;

    @Schema(description = "预计装货时间(小时）")
    private String predictLoaddateTime;

    @Schema(description = "预计卸货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime predictUnloadDate;

    @Schema(description = "预计卸货时间(小时）")
    private String predictUnloaddateTime;

    @Schema(description = "预计卸货完成日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime predictUnloadCompleteDate;

    @Schema(description = "预计卸货完成时间(小时）")
    private String predictUnloadCompleteTime;*/

    @Schema(description = "版本号")
    private Integer version;
}
