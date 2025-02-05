package org.example.weiyuntong.updatelog.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "管理后台 - 修改记录 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GetUpdateLogRespVO extends UpdateLogRespVO {


    private List<Long> ids;

    @Schema(description = "应收/应付")
    private BillTypeEnum billType;


}
