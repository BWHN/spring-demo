package org.example.weiyuntong.bill.vo;

import com.weiyuntong.module.bizcenter.controller.admin.billexpress.vo.BillExpressCreateReqVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "管理后台 - 对账单创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillCreateReqVO extends BillBaseVO {

    @Schema(description = "账单ID")
    private Long billId;

    @Schema(description = "车次ID", example = "[15123445666782413]")
    private List<Long> waybillCarIdList;

    @Schema(description = "账单账期", example = "30")
    private Integer billDay;

    @Schema(description = "邮寄信息")
    private BillExpressCreateReqVO billExpress;
    @Schema(description = "单据")
    private Boolean isDocument;
    @Schema(description = "开票")
    private Boolean upperNeedInvoice;

}
