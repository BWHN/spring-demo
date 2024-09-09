package org.example.weiyuntong.bill.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author FanluNiu
 * @version 1.0
 * @date 2024-03-19 9:48
 */
@Data
public class BillPayDetailPageVO extends PageParam {

    @Schema(description = "公司名称", example = "143")
    private List<String> name;

    @Schema(description = "车牌号", example = "143")
    private String carNumber;

    @Schema(description = "车次号", example = "143")
    private String waybillCarNo;

    @Schema(description = "创建人")
    private String creatorName;

    @Schema(description = "车源联系人")
    private String inviteUserName;

    @Schema(description = "接单人")
    private String receiveOrderName;

    @Schema(description = "会计周期")
    private String unloadTimeBegin;
    private String unloadTimeEnd;

    @Schema(description = "创建时间")
    private String createTimeBegin;
    private String createTimeEnd;

    @Schema(description = "账单类型")
    @NotNull(message = "账单类型不能为空")
    private String billType;

    private Long tenantId;

    private String enterpriseName;

    private String billNo;
}
