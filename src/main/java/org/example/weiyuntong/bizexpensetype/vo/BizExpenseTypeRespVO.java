package org.example.weiyuntong.bizexpensetype.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.bizexpenseimageconfig.BizExpenseImageConfigDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - 费用类型 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BizExpenseTypeRespVO extends BizExpenseTypeBaseVO {

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    private List<BizExpenseImageConfigDO> imageConfigDOS;

}
