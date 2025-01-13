package org.example.weiyuntong.tradehallcarsource.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 交易大厅-车源管理创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TradehallCarSourceCreateReqVO extends TradehallCarSourceBaseVO {

}
