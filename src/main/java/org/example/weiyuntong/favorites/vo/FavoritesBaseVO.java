package org.example.weiyuntong.favorites.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;

/**
* 收藏夹 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class FavoritesBaseVO {

    @Schema(description = "任务ID", example = "26279")
    private Long taskEntrustOrderId;

}
