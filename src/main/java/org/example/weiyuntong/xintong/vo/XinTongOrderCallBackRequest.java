package org.example.weiyuntong.xintong.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class XinTongOrderCallBackRequest {

    //子任务单编号
    @Schema(description = "订单编号", example = "WTD1234")
    @NotNull(message = "订单编号不能为空")
    private String orderCode;
    //审核状态
    @NotNull(message = "审核状态不能为空")
    @Schema(description = "审核状态", example = "true")
    private Boolean status;
    //驳回原因
    @Schema(description = "驳回原因", example = "驳回原因")
    private String reason;
    //二维码图片链接
    @Schema(description = "二维码图片链接", example = "https://www.baidu.com")
    private String files;

}
