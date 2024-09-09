package org.example.weiyuntong.bill.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - 账单车次 Excel 导出 Request VO，参数和 BillCarPageReqVO 是一致的")
@Data
public class BillCarExportReqVO {

    @Schema(description = "账单ID", example = "32624")
    private Long billId;

    @Schema(description = "车次ID", example = "10623")
    private Long waybillCarId;

}
