package org.example.weiyuntong.favorites.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 收藏夹 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FavoritesRespVO extends FavoritesBaseVO {

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
