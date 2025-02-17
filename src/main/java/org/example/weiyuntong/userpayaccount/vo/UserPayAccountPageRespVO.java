package org.example.weiyuntong.userpayaccount.vo;

import com.weiyuntong.module.bizcenter.controller.admin.userpayaccount.dto.ChinaumsPayConfigDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserPayAccountPageRespVO extends UserPayAccountBaseVO {

    /**
     * id
     */
    private Long id;
    /**
     * 配置信息
     */
    private ChinaumsPayConfigDTO configDTO;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
