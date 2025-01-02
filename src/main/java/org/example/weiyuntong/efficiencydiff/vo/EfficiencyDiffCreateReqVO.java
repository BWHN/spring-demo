package org.example.weiyuntong.efficiencydiff.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 效率预警阈值创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EfficiencyDiffCreateReqVO extends EfficiencyDiffBaseVO {

}
