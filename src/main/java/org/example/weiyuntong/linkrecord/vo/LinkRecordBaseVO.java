package org.example.weiyuntong.linkrecord.vo;

import com.weiyuntong.framework.common.enums.ApprovalEnums;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;

/**
* 客户关联 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class LinkRecordBaseVO {

    @Schema(description = "关联货主ID", example = "23583")
    private Long linkId;

    @Schema(description = "关联状态（1.待审核 2.通过审核 3.审核不通过）", example = "1")
    private ApprovalEnums status;

}
