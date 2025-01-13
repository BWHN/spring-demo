package org.example.weiyuntong.tradehallcarsource.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Schema(description = "交易大厅-车源管理-资质完善度 Response VO")
@Data
@ToString(callSuper = true)
public class QualificationCompletenessRespVO {
    @Schema(description = "公司资质完善度", example = "--")
    private String companyQualificationCompleteness;
    @Schema(description = "司机资质完善度", example = "--")
    private String driverQualificationCompleteness;
    @Schema(description = "车辆资质完善度", example = "--")
    private String vehicleQualificationCompleteness;
}
