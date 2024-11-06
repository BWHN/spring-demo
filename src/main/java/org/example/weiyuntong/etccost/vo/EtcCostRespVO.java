package org.example.weiyuntong.etccost.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.OwnTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "管理后台 - ETC费用 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EtcCostRespVO extends EtcCostBaseVO {

    @Schema(description = "id")
    private Long id;
    @Schema(description = "手机号")
    private String phone;
    @Schema(description = "装货地")
    private String loadAddress;
    @Schema(description = "卸货地")
    private String unloadAddress;

    @Schema(description = "空车里程")
    private BigDecimal emptyMileage;
    @Schema(description = "重车里程")
    private BigDecimal loadMileage;
    @Schema(description = "总里程")
    private BigDecimal totalMileage;

    private OwnTypeEnum ownType;

    @Schema(description = "图片list")
    private List<String> imgList;

}
