package org.example.weiyuntong.waybillshare.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class WaybillShareResVO {

    @Schema(description = "运单id", example = "7597")
    private Long waybillId;

    @Schema(description = "电话号", example = "7597")
    List<String> phone;


}
