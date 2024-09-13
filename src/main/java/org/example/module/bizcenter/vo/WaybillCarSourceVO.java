package org.example.module.bizcenter.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 运单货源信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class WaybillCarSourceVO {

    @Schema(description = "车次id")
    private Long id;
    @Schema(description = "车次编号")
    private String waybillCarNo;

    @Schema(description = "装货时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime loadedTime;
    @Schema(description = "装货量")
    private BigDecimal loadedWeight;
    @Schema(description = "装货图片")
    private String loadedImgUrl;
    @Schema(description = "回单")
    private String receiptUrl;
    @Schema(description = "装货里程图片")
    private String loadedMileageUrl;


    @Schema(description = "卸货时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime unloadedTime;
    @Schema(description = "卸货量")
    private BigDecimal unloadedWeight;
    @Schema(description = "卸货图片")
    private String unloadedImgUrl;
    @Schema(description = "卸货回单")
    private String unloadedReceiptUrl;
    @Schema(description = "卸货里程图片")
    private String unloadedMileageUrl;
}
