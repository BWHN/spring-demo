package org.example.weiyuntong.transportorder.vo;

import com.weiyuntong.module.bizcenter.controller.admin.transporttaskentrustorder.vo.TaskDateVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaskWaybillVO {

    @Schema(description = "运单id")
    private Long id;

    @Schema(description = "路书id", example = "14891")
    private Long lineId;

    @Schema(description = "车辆id", example = "21022")
    private Long carId;

    @Schema(description = "车牌号")
    private String carNumber;

    @Schema(description = "司机信息")
    private Long driverId;

    @Schema(description = "押运员信息")
    private Long followId;

    @Schema(description = "付款人")
    private String carrier;
    @Schema(description = "付款人")
    private Long carrierId;
    @Schema(description = "承运商")
    private String capacityName;
    @Schema(description = "承运商")
    private Long capacityId;

    private TaskDateVO taskDateVOS;

    @Schema(description = "发车精度")
    private String departedLng;

    @Schema(description = "发车纬度")
    private String departedLat;

    @Schema(description = "发车地址")
    private String departedAddressName;

    @Schema(description = "发车地到装货地的距离")
    private BigDecimal loadingDistance;

    @Schema(description = "装货地到卸货地的距离")
    private BigDecimal unloadingDistance;


}
