package org.example.weiyuntong.userpayaccount.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import lombok.Data;

@Data
public class UserPayAccountPageReqVO extends PageParam {

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

}
