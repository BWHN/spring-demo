package org.example.weiyuntong.billnew.vo;

import com.weiyuntong.module.bizcenter.controller.admin.waybillsource.vo.WaybillSourceUpdateReqVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class WaybillSourceUpdateBillVO extends WaybillSourceUpdateReqVO {

    @Schema(description = "账单id")
    private Long billId;


}
