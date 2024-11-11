package org.example.weiyuntong.customer.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Customer Response DTO
 *
 * @author 小有可维
 */
@Data
public class CustomerUserRespDTO {

    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户昵称
     */
    private String name;
    /**
     * 手机号码
     */
    private String mobile;

    @Schema(description = "me我自己 customer客户联系人 service   user其他人")
    private String type;
}
