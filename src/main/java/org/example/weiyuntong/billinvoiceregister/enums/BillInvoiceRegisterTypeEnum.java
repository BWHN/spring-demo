package org.example.weiyuntong.billinvoiceregister.enums;

import com.weiyuntong.framework.common.annotaion.enumdesc.IBaseEnum;

public enum BillInvoiceRegisterTypeEnum implements IBaseEnum {

    PAY("开票"),
    RECEIVE("收票");

    private String desc;

    BillInvoiceRegisterTypeEnum(String desc) {
        this.desc = desc;
    }

    @Override
    public String getDesc() {
        return desc;
    }

}
