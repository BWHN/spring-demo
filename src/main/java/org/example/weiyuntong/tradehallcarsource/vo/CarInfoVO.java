package org.example.weiyuntong.tradehallcarsource.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* 交易大厅-车源管理 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CarInfoVO {
    @Schema(description = "车牌号", example = "京A88888")
    private String carNumber;

    @Schema(description = "上次装货产品", example = "芳烃")
    private String lastGoodsName;

    @Schema(description = "车辆类型", example = "灌装车")
    private String carType;

    @Schema(description = "可装介质（普货，二类，三类等）")
    private String carMedium;

    @Schema(description = "是否保温")
    private String carIshot;

    @Schema(description = "是否加热")
    private String carReheat;
    
    @Schema(description = "最大承重")
    private String carMaxwgt;

    @Schema(description = "排放标准（国三，国四，国五等）")
    private String carEmission;
}
