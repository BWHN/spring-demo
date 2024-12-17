package org.example.weiyuntong.favorites.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 收藏夹更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FavoritesUpdateReqVO extends FavoritesBaseVO {

    @Schema(description = "ID", required = true, example = "600")
    @NotNull(message = "ID不能为空")
    private Long id;

}
