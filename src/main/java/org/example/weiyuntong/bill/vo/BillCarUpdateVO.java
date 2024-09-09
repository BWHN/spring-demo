package org.example.weiyuntong.bill.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
* 账单车次 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BillCarUpdateVO {

    @Schema(description = "账单ID", example = "32624")
    private Long billId;

    @Schema(description = "车次ID", example = "10623")
    private List<Long> waybillCarId;

    @Schema(description = "上游付款凭证", example = "143")
    private String upReconciliationImg;

    @Schema(description = "发票id")
    private Long invoiceId;

    @Schema(description = "发票备注")
    private String invoiceRemark;

    @Schema(description = "发票备注文件")
    private String invoiceRemarkImg;

    @Schema(description = "邮寄地址id")
    private Long addressId;

    @Schema(description = "单据")
    private Boolean isDocument;

    @Schema(description = "单据")
    private BillStatusEnum billStatus;

}
