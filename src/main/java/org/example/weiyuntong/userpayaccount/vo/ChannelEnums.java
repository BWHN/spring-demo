package org.example.weiyuntong.userpayaccount.vo;

import com.weiyuntong.framework.common.annotaion.enumdesc.IBaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChannelEnums implements IBaseEnum {

    CHINAUMS("银联商务");

    /**
     * 名字
     */
    private String desc;

}
