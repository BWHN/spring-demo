package org.example.weiyuntong.tradehallgoodssource.vo.tradehall;

import com.weiyuntong.framework.common.pojo.PageParam;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallgoodssource.enums.TimeEnum;
import com.weiyuntong.module.bizcenter.enums.GoodsViewPermissionsEnums;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

import java.util.List;

@Schema(description = "平台大厅分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TradeHallPageReqVO extends PageParam {

    @Schema(description = "订单类型")
    private GoodsViewPermissionsEnums viewPermission;
    @Schema(description = "装货地")
    private String loadAddress;
    @Schema(description = "卸货地")
    private String unLoadAddress;
    @Schema(description = "开始日期-开始")
    private String beginTimeStart;
    @Schema(description = "开始日期-结束")
    private String beginTimeEnd;
    @Schema(description = "结束日期-开始")
    private String endTimeStart;
    @Schema(description = "结束日期-结束")
    private String endTimeEnd;
    @Schema(description = "货物名称")
    private String mediumName;
    @Schema(description = "结算周期")
    private TimeEnum billingCycle;
    @Schema(description = "是否开票")
    private Integer lowerNeedInvoice;
    @Schema(description = "剩余有效期")
    private TimeEnum expireTime;
    @Schema(description = "订单编号")
    private String code;
    @Schema(description = "发布日期-开始")
    private String createTimeStart;
    @Schema(description = "发布日期-结束")
    private String createTimeEnd;

    @Schema(description = "货物类别")
    private List<String> goodsTypeNames;
    @Schema(description = "货物级别")
    private List<String> goodsLevels;

    private boolean needPage = true;
    private Long tenantId;
    private Long userId;
    private List<Long> roleIds;
    private Long ownRoleLabelId;
    // 账期使用天数
    private Integer billingCycleStart;
    private Integer billingCycleEnd;
    // 过期时间使用分钟数
    private Integer expireTimeStart;
    private Integer expireTimeEnd;

    @Schema(description = "前端自定义排序规则")
    private String customOrder;

    @Schema(description = "关键字")
    private String keyword;

    public void handleTime() {
        if (billingCycle != null) {
            billingCycleStart = billingCycle.getStart();
            billingCycleEnd = billingCycle.getEnd();
        }
        if (expireTime != null) {
            Integer end = expireTime.getEnd();
            expireTimeStart = expireTime.getStart() * 24 * 60;
            if (end != null) {
                expireTimeEnd = end * 24 * 60;
            }
        }
    }

    public String getCustomOrder(){
        if (StringUtils.isNotBlank(customOrder)){
            if ("beginTime desc".contains(this.customOrder)){
                return customOrder.replace("beginTime", "tte.load_date");
            }else if ("endTime desc".contains(this.customOrder)){
                return customOrder.replace("endTime", "tte.unload_date");
            } else if ("remainingWeight desc".contains(this.customOrder)) {
                return customOrder.replace("remainingWeight" ,"tte.remaining_weight");
            } else if ("createTime desc".contains(this.customOrder)) {
                return customOrder.replace("createTime", "tte.create_time");
            } else {
                return null;
            }
        }
        return null;
    }


}
