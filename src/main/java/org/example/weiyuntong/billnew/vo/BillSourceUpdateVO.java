package org.example.weiyuntong.billnew.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BillSourceUpdateVO extends BillSourceCreateVO{

    @Schema(description = "id")
    private Long id;

}
