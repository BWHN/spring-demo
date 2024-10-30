package org.example.weiyuntong.customerbill.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * 客户开票信息 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class CustomerBillBaseVO {

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


}
