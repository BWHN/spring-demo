package org.example.weiyuntong.monitor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "车辆监控 - 车辆信息记录")
@Data
public class CarInfoVo {
    @Schema(description = "id", example = "9527")
    String id;

    @Schema(description = "车牌号", example = "鲁E66B53")
    String carNo ;

    @Schema(description = "fleetId", example = "9527")
    String fleetId;

    @Schema(description = "driverId", example = "9527")
    String driverId;

    @Schema(description = "车队名称", example = "化链云科")
    String fleetName;

    @Schema(description = "司机姓名", example = "张无忌")
    String driverName;

    @Schema(description = "司机电话", example = "13801009810")
    String driverMobile;

    @Schema(description = "押运员Id", example = "9527")
    String escortId;

    @Schema(description = "押运员姓名", example = "张毅山")
    String escortName;

    @Schema(description = "押运员", example = "张慧")
    String escortMobile;
}
