package org.example.weiyuntong.bizexpensetype.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.bizexpenseimageconfig.BizExpenseImageConfigDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;
import java.util.List;

@Schema(description = "管理后台 - 费用类型创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BizExpenseTypeCreateReqVO extends BizExpenseTypeBaseVO {

    List<BizExpenseImageConfigDO> imageConfigDOS;

}
