package org.example.weiyuntong.abnormalorderassign.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "运营中心-异常管理 - 委托失效分配记录创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AbnormalOrderAssignCreateReqVO extends AbnormalOrderAssignBaseVO {

}
