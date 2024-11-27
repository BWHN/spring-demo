package org.example.weiyuntong.roadbridgecost.vo;

import com.weiyuntong.framework.desensitize.core.slider.annotation.FixedPhoneDesensitize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "管理后台 - 路桥费用 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RoadBridgeCostRespVO extends RoadBridgeCostBaseVO {

    @Schema(description = "id")
    private Long id;
    @Schema(description = "装货地")
    private String loadAddress;
    @Schema(description = "卸货地")
    private String unloadAddress;
    @Schema(description = "空车里程")
    private String emptyMileage;
    @Schema(description = "重车里程")
    private String loadMileage;
    @Schema(description = "总里程")
    private String totalMileage;
    @Schema(description = "手机号")
    @FixedPhoneDesensitize(prefixKeep = 3, suffixKeep = 4)
    private String phone;
    @Schema(description = "上报时间")
    private String createTime;

    @Schema(description = "图片list")
    private List<String> imgList;

}
