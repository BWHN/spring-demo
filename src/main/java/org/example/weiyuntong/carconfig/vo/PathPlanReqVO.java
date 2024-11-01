package org.example.weiyuntong.carconfig.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PathPlanReqVO {

    @Schema(description = "发货地经纬度", example = "183.128734,32.08723")
    private String startGps;

    @Schema(description = "收货地经纬度", example = "183.128734,32.08723")
    private String endGps;


}
