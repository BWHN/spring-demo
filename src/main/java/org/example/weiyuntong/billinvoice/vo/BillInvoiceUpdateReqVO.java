package org.example.weiyuntong.billinvoice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 账单发票更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillInvoiceUpdateReqVO extends BillInvoiceBaseVO {

    @Schema(description = "ID", required = true, example = "13018")
    @NotNull(message = "ID不能为空")
    private Long id;

}
