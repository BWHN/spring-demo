package org.example.weiyuntong.wxmessage.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 车次微信通知记录更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WXMessageUpdateReqVO extends WXMessageBaseVO {

    @Schema(description = "ID", required = true, example = "13090")
    @NotNull(message = "ID不能为空")
    private Long id;

}
