package org.example.weiyuntong.customer.vo;

import com.weiyuntong.module.bizcenter.enums.CustomerBackEnums;
import com.weiyuntong.module.bizcenter.enums.CustomerTypeEnums;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CustomerLinkInfoVO {
    @Schema(description = "客户名称", example = "王五")
    private String customerName;

    @Schema(description = "客户所属行业")
    private String customerIndustry;

    @Schema(description = "客户类型（1.生产商，2.贸易商，3.物流商，4.中介商等）", example = "1")
    private CustomerTypeEnums customerType;

    @Schema(description = "企业类型（国企，民企）", example = "1")
    private String enterpriseType;

    @Schema(description = "客户背书（上市公司，500强等）")
    private CustomerBackEnums customerBack;

    @Schema(description = "产品种类（普货，二类，三类等）", example = "2")
    private String goodsType;

    @Schema(description = "企业联络人电话")
    private String customerPeoPhone;

    @Schema(description = "客户ID", required = true, example = "26848")
    private Long id;
}
