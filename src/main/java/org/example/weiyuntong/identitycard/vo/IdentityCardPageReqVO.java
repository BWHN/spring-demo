package org.example.weiyuntong.identitycard.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 用户身份信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IdentityCardPageReqVO extends PageParam {

    @Schema(description = "用户ID", example = "9226")
    private Long userId;

    @Schema(description = "姓名", example = "王五")
    private String name;

    @Schema(description = "身份证开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] cardBeginTime;

    @Schema(description = "身份证到期时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] cardExpirationTime;

    @Schema(description = "身份证照片正面")
    private String cardMain;

    @Schema(description = "身份证照片背面")
    private String cardRevolt;

    @Schema(description = "性别（1男 2女）")
    private String sex;

    @Schema(description = "审核状态", example = "2")
    private String status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
