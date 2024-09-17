package org.example.weiyuntong.abnormalorderrecord.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "运营中心-异常管理-委托失效记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AbnormalOrderRecordPageReqVO extends PageParam {

    @Schema(description = "编码")
    private String code;

    @Schema(description = "关联的id", example = "19381")
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
    @Schema(description = "货源名称")
    private String mediumName;

    @Schema(description = "装货地省名称")
    private String sendProvinceName;

    @Schema(description = "装货地城市名称")
    private String sendCityName;

    @Schema(description = "装货地区域名称")
    private String sendDistrictName;

    @Schema(description = "卸货地省名称")
    private String receiveProvinceName;


    @Schema(description = "卸货地城市名称")
    private String receiveCityName;

    @Schema(description = "卸货地区域名称")
    private String receiveDistrictName;

    @Schema(description = "装货日期")
    private LocalDate loadDate;
}
