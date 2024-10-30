package org.example.weiyuntong.customerbill.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 客户开票信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CustomerBillPageReqVO extends PageParam {

    @Schema(description = "编号", example = "KP123")
    private String code;

    @Schema(description = "抬头名称（公司名称）", example = "张三")
    private String name;

    @Schema(description = "税号")
    private String taxNum;

    @Schema(description = "开户行")
    private String bank;

    @Schema(description = "支行")
    private String branchNum;

    @Schema(description = "银行卡号")
    private String bankNum;

    @Schema(description = "电话号")
    private String phone;

    @Schema(description = "单位地址")
    private String address;

    @Schema(description = "客户id", example = "6637")
    private Long customerId;

    @Schema(description = "创建人Id", example = "6637")
    private Long creator;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
