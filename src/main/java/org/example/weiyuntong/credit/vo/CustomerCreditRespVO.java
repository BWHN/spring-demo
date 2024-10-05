package org.example.weiyuntong.credit.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 客户赊销 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CustomerCreditRespVO extends CustomerCreditBaseVO {

    @Schema(description = "ID", required = true, example = "6764")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "客户名称", example = "李四")
    @TableField(exist = false)
    private String name;

    @Schema(description = "客户评级")
    @TableField(exist = false)
    private String level;

    @Schema(description = "客户类型（1.生产商，2.贸易商，3.物流商，4.中介商等）", example = "1")
    @TableField(exist = false)
    private String type;

    @Schema(description = "客户状态（1.潜在客户，2.机会客户，3.成单客户，4.优质客户）", example = "2")
    @TableField(exist = false)
    private String status;

}
