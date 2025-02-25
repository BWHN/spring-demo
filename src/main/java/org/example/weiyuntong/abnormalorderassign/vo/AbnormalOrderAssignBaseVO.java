package org.example.weiyuntong.abnormalorderassign.vo;

import com.weiyuntong.module.bizcenter.enums.CustomerStatusEnums;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

/**
* 委托失效分配记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AbnormalOrderAssignBaseVO {

    @Schema(description = "编码")
    private String code;

    @Schema(description = "关联的id", example = "5606")
    private Long associatedId;

    @Schema(description = "异常记录id")
    private Long abnormalId;

    @Schema(description = "公司id", example = "112")
    private String companyId;

    @Schema(description = "公司名称", example = "南京维链数字科技有限公司")
    private String companyName;

    @Schema(description = "人员id", example = "120")
    private String userId;

    @Schema(description = "人员名称", example = "赵总")
    private String userName;

    @Schema(description = "分配状态设定", example = "潜在客户")
    private CustomerStatusEnums assignStatus;

    @Schema(description = "备注信息", example = "请输入分配说明")
    private String remark;

    @Schema(description = "状态", example = "1")
    private Byte status;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "创建者姓名")
    private String creatorName;
}
