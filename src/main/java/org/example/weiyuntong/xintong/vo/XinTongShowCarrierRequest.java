package org.example.weiyuntong.xintong.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class XinTongShowCarrierRequest {
    //子任务单编号
    @NotNull(message = "订单编号不能为空")
    @Schema(description = "订单编号", example = "WTD1234")
    private String orderCode;
}
