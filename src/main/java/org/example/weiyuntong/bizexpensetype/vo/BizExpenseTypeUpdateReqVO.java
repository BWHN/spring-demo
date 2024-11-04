package org.example.weiyuntong.bizexpensetype.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.bizexpenseimageconfig.BizExpenseImageConfigDO;
import com.weiyuntong.module.bizcenter.enums.ImprestStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;
import java.util.List;

@Schema(description = "费用类型更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BizExpenseTypeUpdateReqVO extends BizExpenseTypeBaseVO {

     List<BizExpenseImageConfigDO> imageConfigDOS;
     List<Long> delImgList;

     @Schema(description = "费用类型是否启用备用金:启用:ENABLE，停用:DISABLE")
     private ImprestStatusEnum imprestStatus;

     @Schema(description = "费用类型是否删除:删除:TRUE，未删除:FALSE")
     private Boolean deleted;
}
