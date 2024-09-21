package org.example.weiyuntong.billcontacts.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;

/**
* 账单联系人 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BillContactsBaseVO {

    @Schema(description = "账单id", example = "25559")
    private Long billId;

    @Schema(description = "接单方：CARRIER；发布方：CONSIGNOR", example = "1")
    private String type;

    @Schema(description = "联系人姓名", example = "赵六")
    private String contactsName;

    @Schema(description = "联系人电话")
    private String contactsPhone;

    @Schema(description = "负责人姓名", example = "王五")
    private String headName;

    @Schema(description = "负责人电话")
    private String headPhone;

    @Schema(description = "创建者联系电话")
    private String creatorPhone;

}
