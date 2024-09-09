package org.example.weiyuntong.bill.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - 账单车次分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillCarPageReqVO extends PageParam {

    @Schema(description = "账单ID", example = "32624")
    private Long billId;

    @Schema(description = "车次ID", example = "10623")
    private Long waybillCarId;

}
