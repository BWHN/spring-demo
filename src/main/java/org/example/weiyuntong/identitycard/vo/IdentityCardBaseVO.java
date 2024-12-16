package org.example.weiyuntong.identitycard.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.identitycard.AuthTypeEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.identitycard.IdentityCardStatusEnum;
import com.weiyuntong.module.fleetcenter.dal.dataobject.driver.DriverDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;

/**
* 用户身份信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class IdentityCardBaseVO {

    @Schema(description = "用户ID", example = "9226")
    private Long userId;

    @Schema(description = "姓名", example = "王五")
    private String name;

    @Schema(description = "身份证开始时间")
    private String cardBeginTime;

    @Schema(description = "身份证到期时间")
    private String cardExpirationTime;

    @Schema(description = "身份证照片正面")
    private String cardMain;

    @Schema(description = "身份证照片背面")
    private String cardRevolt;

    @Schema(description = "性别（1男 2女）")
    private String sex;

    @Schema(description = "审核状态", example = "2")
    private String status;

    /**
     * 身份证号
     */
    @Schema(description = "身份证号", example = "320000199001081001")
    private String identityCard;

    private String getStatusDesc() {
        return IdentityCardStatusEnum.instanceOf(status).getDesc();
    }

    @Schema(description = "司机/押运员信息", example = "2")
    private DriverDO driver;

    @Schema(description = "认证类型", example = "2")
    private AuthTypeEnum authType;
}
