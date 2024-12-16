package org.example.weiyuntong.identitycard.vo;

import com.weiyuntong.module.system.dal.dataobject.enterprise.EnterpriseDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 用户身份信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IdentityCardRespVO extends IdentityCardBaseVO {

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "企业信息")
    private EnterpriseDO enterprise;
}
