package org.example.weiyuntong.identitycard.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户身份信息 Excel VO
 *
 * @author 维运通
 */
@Data
public class IdentityCardExcelVO {

    @ExcelProperty("用户ID")
    private Long userId;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("身份证开始时间")
    private LocalDateTime cardBeginTime;

    @ExcelProperty("身份证到期时间")
    private LocalDateTime cardExpirationTime;

    @ExcelProperty("身份证照片正面")
    private String cardMain;

    @ExcelProperty("身份证照片背面")
    private String cardRevolt;

    @ExcelProperty("性别（1男 2女）")
    private String sex;

    @ExcelProperty("审核状态")
    private String status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
