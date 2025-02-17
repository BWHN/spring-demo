package org.example.weiyuntong.userpayaccount.vo;

import com.weiyuntong.module.bizcenter.controller.admin.userpayaccount.dto.ChinaumsPayConfigDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - 用户付款账户信息管理创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserPayAccountUpdateReqVO extends UserPayAccountBaseVO {

    /**
     * id
     */
    private Long id;
    /**
     * 配置信息
     */
    private ChinaumsPayConfigDTO configDTO;

}
