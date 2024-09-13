package org.example.module.bizcenter.vo;

import com.weiyuntong.module.bizcenter.enums.SourceEnums;
import com.weiyuntong.module.bizcenter.enums.SourceEventEnums;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 运单货源信息 Response VO")
@Data
@ToString(callSuper = true)
public class WaybillSourceEventRespVO {

    private int type;

    @Schema(description = "当前状态名称")
    private SourceEventEnums status;

    @Schema(description = "下一个状态")
    private SourceEnums nextStatus;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime eventTime;

    @Schema(description = "姓名")
    private String userName;

}
