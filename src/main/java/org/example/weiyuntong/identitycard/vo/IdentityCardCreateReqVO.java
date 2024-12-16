package org.example.weiyuntong.identitycard.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 用户身份信息创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IdentityCardCreateReqVO extends IdentityCardBaseVO {


    @Schema(description = "企业名称")
    private String entName;

    @Schema(description = "营业执照（电子扫描件）")
    private String businessLicenseImg;

    @Schema(description = "组织机构代码")
    private String orgCode;

    @Schema(description = "法人姓名", example = "小有可维")
    private String corporateName;

    @Schema(description = "省份名称")
    private String provinceName;

    @Schema(description = "省份编码")
    private Long provinceCode;

    @Schema(description = "市名称")
    private String cityName;

    @Schema(description = "市编码")
    private Integer cityCode;

    @Schema(description = "区名称")
    private String districtName;

    @Schema(description = "区编码")
    private Integer districtCode;

    @Schema(description = "企业详细地址")
    private String detailAddress;

    @Schema(description = "营业执照开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime businessBeginTime;

    @Schema(description = "营业执照结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime businessEndTime;

    @Schema(description = "货主-危险品经营/安全生产许可证 企业名称")
    private String securityEntName;

    @Schema(description = "危险品经营/安全生产许可证（电子扫描件）")
    private String securityImg;

    @Schema(description = "货主-危险品经营/安全生产许可证")
    private String securityCode;

    @Schema(description = "危险品经营/安全生产许可证 法人姓名")
    private String securityCorporateName;

    @Schema(description = "道路运输经营许可证（电子扫描件）")
    private String transportImg;

    @Schema(description = "承运商-道路运输经营许可证（电子扫描件）")
    private String transportCode;

    @Schema(description = "道路运输经营许可证开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime transportBeginTime;

    @Schema(description = "道路运输经营许可证结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime transportEndTime;

    @Schema(description = "车源负责人", example = "2")
    private String carContacts;

    @Schema(description = "车源负责人电话", example = "2")
    private String carContactsPhone;

    @Schema(description = "省份名称")
    private String transportProvinceName;

    @Schema(description = "省份编码")
    private Long transportProvinceCode;

    @Schema(description = "市名称")
    private String transportCityName;

    @Schema(description = "市编码")
    private Integer transportCityCode;

    @Schema(description = "区名称")
    private String transportDistrictName;

    @Schema(description = "区编码")
    private Integer transportDistrictCode;

    @Schema(description = "企业停车场位置")
    private String parkingLot;

    @Schema(description = "常跑路线起地", example = "张三")
    private String beginName;

    @Schema(description = "常跑线路起编码", example = "张三")
    private String beginCode;

    @Schema(description = "常跑路线末地", example = "张三")
    private String endName;

    @Schema(description = "常跑路线末地code", example = "张三")
    private String endCode;

    @Schema(description = "线路id", example = "张三")
    private Long teamId;

}
