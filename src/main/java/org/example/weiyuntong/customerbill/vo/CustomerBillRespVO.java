package org.example.weiyuntong.customerbill.vo;

import cn.hutool.core.util.ObjUtil;
import com.weiyuntong.framework.web.core.util.WebFrameworkUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 客户开票信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CustomerBillRespVO extends CustomerBillBaseVO {

    @Schema(description = "ID", required = true, example = "24067")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

    @Schema(description = "创建人id", example = "6637")
    private Long creator;

    public Boolean getCanUpdate() {
        return ObjUtil.equals(creator, WebFrameworkUtils.getLoginUserId());
    }
}
