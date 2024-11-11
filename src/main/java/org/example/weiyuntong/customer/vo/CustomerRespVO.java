package org.example.weiyuntong.customer.vo;

import com.weiyuntong.module.bizcenter.controller.admin.customercreditchange.vo.CustomerCreditChangeRespVO;
import com.weiyuntong.module.bizcenter.dal.dataobject.customercontacts.CustomerContactsDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.customerline.CustomerLineDO;
import com.weiyuntong.module.system.controller.admin.enterpriseusedinfo.vo.EnterpriseUsedInfoRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "管理后台 - 客户 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CustomerRespVO extends CustomerBaseVO {

    @Schema(description = "资金池流向")
    private List<CustomerCreditChangeRespVO> creditBaseVOList;

    private List<CustomerContactsDO> customerContactsDOS;

    List<CustomerLineDO> customerLineDOS;

    @Schema(description = "客户默认结算要求")
    private EnterpriseUsedInfoRespVO enterpriseUsedInfo;

}
