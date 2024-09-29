package org.example.weiyuntong.billinvoice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* 账单发票 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BillInvoicePostVO extends BillInvoiceBaseVO{

    @Schema(description = "是否邮寄" )
    private Boolean whetherPost;
}
