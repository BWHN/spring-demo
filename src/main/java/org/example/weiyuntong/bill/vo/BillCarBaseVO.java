package org.example.weiyuntong.bill.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.PayableStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;


/**
* 账单车次 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BillCarBaseVO {

    @Schema(description = "账单ID", example = "32624")
    private Long billId;

    @Schema(description = "车次ID", example = "10623")
    private Long waybillCarId;

    /**
     * 实付金额
     */
    @Schema(description = "实付金额")
    private BigDecimal paidAmount;

    /**
     * 应付金额
     */
    @Schema(description = "应付金额")
    private BigDecimal payableAmount;

    /**
     * 收付款状态
     */
    @Schema(description = "应付金额")
    private PayableStatusEnum payableStatus;

}
