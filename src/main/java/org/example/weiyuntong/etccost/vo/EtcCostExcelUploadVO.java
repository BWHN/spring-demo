package org.example.weiyuntong.etccost.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class EtcCostExcelUploadVO {

    @Schema(description = "文件列表")
    private List<String> fileUrlList;
    @Schema(description = "年月信息")
    private String yearMonth;

}
