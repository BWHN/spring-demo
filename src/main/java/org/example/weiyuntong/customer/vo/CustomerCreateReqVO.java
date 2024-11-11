package org.example.weiyuntong.customer.vo;

import com.weiyuntong.module.system.controller.admin.enterpriseusedinfo.vo.EnterpriseUsedInfoCreateReqVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - 客户创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CustomerCreateReqVO extends CustomerBaseVO {

    @Schema(description = "客户默认结算要求")
    private EnterpriseUsedInfoCreateReqVO enterpriseUsedInfo;

}
