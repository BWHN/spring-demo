package org.example.weiyuntong.billcontacts.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 账单联系人分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillContactsPageReqVO extends PageParam {

    @Schema(description = "账单id", example = "25559")
    private Long billId;

    @Schema(description = "接单方：CARRIER；发布方：CONSIGNOR", example = "1")
    private String type;

    @Schema(description = "联系人姓名", example = "赵六")
    private String contactsName;

    @Schema(description = "联系人电话")
    private String contactsPhone;

    @Schema(description = "负责人姓名", example = "王五")
    private String headName;

    @Schema(description = "负责人电话")
    private String headPhone;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "创建者联系电话")
    private String creatorPhone;

}