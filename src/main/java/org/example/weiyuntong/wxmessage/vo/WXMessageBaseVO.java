package org.example.weiyuntong.wxmessage.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* 车次微信通知记录 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class WXMessageBaseVO {

    @Schema(description = "企业编号", example = "30506")
    private Long entId;

    @Schema(description = "车次ID", example = "7409")
    private Long waybillCarId;

    @Schema(description = "车次编号")
    private String waybillCarNo;

    @Schema(description = "消息模板ID", example = "6056")
    private String templateId;

    @Schema(description = "是否发送成功 0失败 1成功")
    private Boolean successful;

    @Schema(description = "触发方式  0下发 1时间触发 2围栏触发", example = "2")
    private Boolean sentType;

}
