package org.example.weiyuntong.updatelog.vo;

import com.weiyuntong.module.bizcenter.enums.ContentEnums;
import com.weiyuntong.module.bizcenter.enums.NodeEnums;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* 修改记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class UpdateLogBaseVO {
    @Schema(description = "业务json", example = "7078")
    private String contentJson;

    @Schema(description = "关联id", example = "7078")
    private Long linkId;

    @Schema(description = "修改项")
    private ContentEnums updateModified;

    @Schema(description = "修改节点")
    private NodeEnums updateNode;

    @Schema(description = "修改前")
    private String beforeContent;

    @Schema(description = "修改后")
    private String endContent;

    @Schema(description = "修改项名称")
    private String itemName;

    @Schema(description = "备注")
    private String remark;

}
