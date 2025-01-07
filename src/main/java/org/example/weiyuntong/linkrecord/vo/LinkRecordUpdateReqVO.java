package org.example.weiyuntong.linkrecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 客户关联更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LinkRecordUpdateReqVO extends LinkRecordBaseVO {

    @Schema(description = "ID", required = true, example = "9087")
    @NotNull(message = "ID不能为空")
    private Long id;

}
