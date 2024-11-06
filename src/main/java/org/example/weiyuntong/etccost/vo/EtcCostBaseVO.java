package org.example.weiyuntong.etccost.vo;

import com.weiyuntong.module.fleetcenter.controller.admin.cost.vo.CostBaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.*;

/**
* ETC费用 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class EtcCostBaseVO extends CostBaseVO {

    @Schema(description = "进站口")
    private String startAddressName;
    @Schema(description = "进站经度")
    private String startLng;
    @Schema(description = "进站纬度")
    private String startLat;
    @Schema(description = "进站里程")
    private BigDecimal startMileage;
    @Schema(description = "进站照片")
    private String startMileageUrl;
    @Schema(description = "进站时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE)
    private LocalDateTime startTime;
    @Schema(description = "出站口")
    private String endAddressName;
    @Schema(description = "出站经度")
    private String endLng;
    @Schema(description = "出站纬度")
    private String endLat;
    @Schema(description = "出站里程")
    private BigDecimal endMileage;
    @Schema(description = "出站照片")
    private String endMileageUrl;
    @Schema(description = "出站时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE)
    private LocalDateTime endTime;
    @Schema(description = "是否有路书 0 否 1 是")
    private Integer hasTravelGuide;
    @Schema(description = "预估费用")
    private BigDecimal predictMoney;
    @Schema(description = "费用id", example = "27820")
    private Long costId;
    @Schema(description = "进站详情", example = "小有可维")
    private String startAddressAddr;
    @Schema(description = "出站详情", example = "小有可维")
    private String endAddressAddr;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "账单日期")
    private LocalDateTime billDate;
    @Schema(description = "ETC金额")
    private BigDecimal etcMoney;
    @Schema(description = "空重车 0 空车 1 重车")
    private Integer loaded;
    @Schema(description = "导入年月")
    private String uploadTime;

}
