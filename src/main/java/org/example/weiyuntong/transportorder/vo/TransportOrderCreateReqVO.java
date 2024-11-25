package org.example.weiyuntong.transportorder.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;


@Schema(description = "管理后台 - 订单创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TransportOrderCreateReqVO extends TransportOrderBaseVO {

    @Schema(description = "企业信息指派",example = "1")
    private List<TaskOrderCapacityVO> taskEntrustOrderDOList;

    @Schema(description = "是否保存客户信息")
    private Boolean isSaveCustomer = false;

}
