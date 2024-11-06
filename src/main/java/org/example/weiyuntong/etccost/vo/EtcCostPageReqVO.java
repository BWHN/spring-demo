package org.example.weiyuntong.etccost.vo;

import cn.hutool.core.util.ObjectUtil;
import com.weiyuntong.framework.common.pojo.PageParam;
import com.weiyuntong.module.bizcenter.enums.ExpenseStatusEnum;
import com.weiyuntong.module.bizcenter.enums.PayStatusEnum;
import com.weiyuntong.module.fleetcenter.enums.CostTypeEnum;
import com.weiyuntong.module.fleetcenter.enums.DataFromEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Schema(description = "管理后台 - ETC费用分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EtcCostPageReqVO extends PageParam {

    @Schema(description = "审核状态")
    private ExpenseStatusEnum expenseStatus;
    @Schema(description = "车牌号")
    private String carNumber;
    @Schema(description = "车辆归属 1 自有 2 租赁")
    private Integer carBelong;
    @Schema(description = "车次编码")
    private String waybillCarNo;
    @Schema(description = "会计周期", example = "2024-04")
    private String cycle;
    @Schema(description = "司机名称")
    private String driverName;
    @Schema(description = "ETC消耗值下限")
    private BigDecimal ureaLimitStart;
    @Schema(description = "ETC消耗值上限")
    private BigDecimal ureaLimitEnd;
    @Schema(description = "消费日期开始")
    private String costTimeStart;
    @Schema(description = "消费日期结束")
    private String costTimeEnd;
    @Schema(description = "费用上传到系统时间开始")
    private String createTimeStart;
    @Schema(description = "费用上传到系统时间结束")
    private String createTimeEnd;
    @Schema(description = "数据来源")
    private DataFromEnum dataFrom;
    @Schema(description = "消费方式")
    private CostTypeEnum type;
    @Schema(description = "是否定点 0：否 1：是")
    private Integer location;
    @Schema(description = "定点单位名称")
    private String locationName;
    @Schema(description = "支付状态 已支付、待支付、无需支付")
    private PayStatusEnum payStatus;
    @Schema(description = "装货地")
    private String loadAddress;
    @Schema(description = "卸货地")
    private String unloadAddress;
    @Schema(description = "是否有路书 0 否 1 是")
    private Integer hasTravelGuide;
    @Schema(description = "費用编码")
    private String code;

    @Schema(description = "当前审核人ID")
    private Long currentReviewerId;
    @Schema(description = "登录人ID")
    private Long loginUserId;
    @Schema(description = "是否关联车次 0否 1是")
    private Integer correlationCC;

    public String getCycleStart() {
        return timeStart(this.cycle);
    }

    public String getCycleEnd() {
        return timeEnd(this.cycle);
    }

    public static String timeStart(String yearMonth) {
        if (yearMonth != null) {
            return yearMonth + "-01 00:00:00";
        }
        return null;
    }

    public static String timeEnd(String yearMonth) {
        if (yearMonth != null) {
            String temp = timeStart(yearMonth);
            try {
                Calendar instance = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date parse = sdf.parse(temp);
                instance.setTime(parse);
                instance.add(Calendar.MONTH, 1);
                instance.add(Calendar.DAY_OF_MONTH, -1);
                return sdf.format(instance.getTime()) + " 23:59:59";
            } catch (ParseException e) {}
        }
        return null;
    }

    public void handleExpenseStatus(Long loginUserId) {
        // 已驳回，该公司当前已驳回的所有记录
        if (ObjectUtil.equals(expenseStatus, ExpenseStatusEnum.REJECTED)) {
            this.currentReviewerId = null;
            this.loginUserId = null;
            // 已审核，登录人参与审核的记录
        } else if (ObjectUtil.equals(expenseStatus, ExpenseStatusEnum.APPROVED)){
            this.expenseStatus = null;
            this.currentReviewerId = null;
            this.loginUserId = loginUserId;
            // 待审核，登录人是当前审核人
        } else if (ObjectUtil.equals(expenseStatus, ExpenseStatusEnum.PENDING_REVIEW)){
            this.currentReviewerId = loginUserId;
            this.loginUserId = null;
        } else if (ObjectUtil.equals(expenseStatus, ExpenseStatusEnum.DEFAULT)) {
            this.currentReviewerId = null;
            this.loginUserId = null;
        } else {
            // 全部
            this.expenseStatus = null;
            this.currentReviewerId = null;
            this.loginUserId = null;
        }
    }

}
