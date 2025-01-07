package org.example.weiyuntong.linkrecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;
import java.util.Collection;

@Schema(description = "管理后台 - 客户关联创建 Request VO")
@Data
@ToString(callSuper = true)
public class LinkRecordCreateReqVO {

    @Schema(description = "批量关联货主时使用的ids")
    private Collection<Long> ids;

}
