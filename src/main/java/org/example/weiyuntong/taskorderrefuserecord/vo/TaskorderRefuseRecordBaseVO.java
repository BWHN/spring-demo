package org.example.weiyuntong.taskorderrefuserecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;

/**
* 任务单拒绝记录信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class TaskorderRefuseRecordBaseVO {

    @Schema(description = "关联的任务Id", required = false, example = "10457")
    private Long taskId;

    @Schema(description = "企业id", required = false, example = "3978")
    private Long entId;

    @Schema(description = "关联的任务委托单Id", required = false, example = "2032")
    private Long taskEntrustId;

    @Schema(description = "拒绝其他备注信息", example = "报价无法接受")
    private String remark;

    @Schema(description = "拒绝原因，支持多选，以逗号分隔", example = "所报运价太高")
    private String refuseReason;

}
