package org.example.weiyuntong.abnormalorderrecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;

/**
* 委托失效记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AbnormalOrderRecordBaseVO {
    @Schema(description = "id")
    private Long id;
    @Schema(description = "编码")
    private String code;

    @Schema(description = "关联的id", example = "10066")
    private Long associatedId;

    @Schema(description = "类型", example = "1")
    private String type;

    @Schema(description = "备注信息", example = "随便")
    private String remark;

    @Schema(description = "处理状态:已处理、未处理", example = "1")
    private String status;

    @Schema(description = "记录最后的状态", example = "2")
    private String finalStatus;

}
