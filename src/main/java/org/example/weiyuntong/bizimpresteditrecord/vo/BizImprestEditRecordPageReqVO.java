package org.example.weiyuntong.bizimpresteditrecord.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 备用金修改记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BizImprestEditRecordPageReqVO extends PageParam {

    @Schema(description = "编码")
    private String code;

    @Schema(description = "备用金ID", example = "19611")
    private Long imprestId;

    @Schema(description = "备用金修改前金额")
    private BigDecimal editBeforeAmount;

    @Schema(description = "备用金修改后金额")
    private BigDecimal editAfterAmount;

    @Schema(description = "备注", example = "你猜")
    private String remark;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "版本号")
    private Integer version;

}
