package org.example.weiyuntong.abnormalorderassign.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "运营中心-异常管理 - 委托失效分配记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AbnormalOrderAssignPageReqVO extends PageParam {

    @Schema(description = "编码")
    private String code;

    @Schema(description = "关联的id", example = "5606")
    private Long associatedId;

    @Schema(description = "公司id", example = "21243")
    private String companyId;

    @Schema(description = "公司名称", example = "小有可维")
    private String companyName;

    @Schema(description = "人员id", example = "7261")
    private String userId;

    @Schema(description = "人员名称", example = "小有可维")
    private String userName;

    @Schema(description = "分配状态设定", example = "2")
    private String assignStatus;

    @Schema(description = "备注信息", example = "你猜")
    private String remark;

    @Schema(description = "状态", example = "1")
    private Byte status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
