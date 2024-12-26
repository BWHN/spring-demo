package org.example.weiyuntong.refuserecord.vo;

import com.weiyuntong.module.bizcenter.enums.RefuseTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* 撤销信息记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class RefuseRecordBaseVO {

    @Schema(description = "租户id", required = true)
    private Long tenantId;
    @Schema(description = "货主/托运人id")
    private Long consignorId;

    @Schema(description = "承运商id")
    private Long carrierId;

    @Schema(description = "拒绝编码", required = true)
    private String code;

    @Schema(description = "关联的id", required = true, example = "16414")
    //@NotNull(message = "关联的id不能为空")
    private Long associatedId;

    @Schema(description = "拒绝类型:", example = "1")
    private RefuseTypeEnum type;

    @Schema(description = "拒绝节点")
    private String refuseNode;

    @Schema(description = "拒绝原因，支持多选，以逗号分隔", example = "不对")
    private String refuseReason;

    @Schema(description = "备注信息", example = "随便")
    private String remark;

}
