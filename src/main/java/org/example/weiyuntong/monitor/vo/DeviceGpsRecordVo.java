package org.example.weiyuntong.monitor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "车辆监控 - 车辆GPS记录")
@Data
public class DeviceGpsRecordVo {
    @Schema(description = "车牌号", example = "鲁E66B53")
    String carNumber ;

    @Schema(description = "手机号", example = "鲁E66B53")
    String mobile ;

    @Schema(description = "设备编号", example = "支持以设备编号、小程序用户的wxid、SIM卡")
    String deviceNo;

    @Schema(description = "采集时间", example = "1626082258718")
    @NotNull(message = "采集时间不能为空")
    String tmStr;

    @Schema(description = "经度", example = "101.00")
    @NotNull(message = "经度不能为空")
    String lng ;

    @Schema(description = "纬度", example = "21.23")
    @NotNull(message = "维度不能为空")
    String lat;

    @Schema(description = "位置", example = "车辆位置")
    String locName;

    @Schema(description = "行驶方位", example = "")
    String direct;

    @Schema(description = "速度", example = "米/秒,会以实际的经纬度进行计算")
    String speed;

    @Schema(description = "来源", example = "具体指app/mini/sim等")
    String sourceFlag;
}
