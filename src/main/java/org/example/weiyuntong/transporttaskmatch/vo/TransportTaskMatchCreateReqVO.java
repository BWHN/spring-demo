package org.example.weiyuntong.transporttaskmatch.vo;

import com.weiyuntong.framework.common.util.string.StringUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 运输任务匹配信息创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TransportTaskMatchCreateReqVO extends TransportTaskMatchBaseVO {

    private String carId;

    private String entId;

    @Override
    public String getVehicleMatch() {
        if (StringUtil.isEmpty(super.getVehicleMatch())) {
            return carId;
        }

        return super.getVehicleMatch();
    }

    @Override
    public String getEntMatch() {
        if (StringUtil.isEmpty(super.getEntMatch())) {
            return entId;
        }

        return super.getEntMatch();
    }
}
