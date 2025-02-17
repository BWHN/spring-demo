package org.example.weiyuntong.userpayaccount.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillStatusEnum;
import lombok.Data;

/**
* 用户付款账户信息管理 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class UserPayAccountBaseVO {

    /**
     * 账户编码
     */
    private String code;

    /**
     * 账户名称
     */
    private String accountName;

    /**
     * 账户卡号
     */
    private String accountNumber;

    /**
     * 开户行
     */
    private String openingBank;

    /**
     * 账户类型:0：对公；1：对私
     */
    private Integer accountType;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 支付渠道
     */
    private ChannelEnums channel;

    /**
     * 是否默认账户 0：否 1：是
     */
    private Integer defaultAccount;

    /**
     * 线上支付开关 0： 关闭 1：开启
     */
    private Integer onlineStatus;

    /**
     * 配置参数
     */
    private String config;
}
