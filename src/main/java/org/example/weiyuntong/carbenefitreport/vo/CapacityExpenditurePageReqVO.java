package org.example.weiyuntong.carbenefitreport.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.OwnTypeEnum;
import com.weiyuntong.module.system.service.permission.dto.RoleDataDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 运力支出 分页查询条件
 */

@Data
public class CapacityExpenditurePageReqVO extends RoleDataDTO {

    @Schema(description = "统计周期 年/月")
    private String cycle;

    @Schema(description = "会计周期")
    private String cycleStart;
    private String cycleEnd;

    @Schema(description = "承运人")
    private String carrier;

    @Schema(description = "车源负责人-姓名")
    private String carCorporateName;


    @Schema(description = "卸货时间开始")
    private String unloadedTimeStart;
    @Schema(description = "卸货时间结束")
    private String unloadedTimeEnd;

    @Schema(description = "租户id")
    private Long tenantId;

    @Schema(description = "导出表头")
    private List<String> header;

    @Schema(description = "是否分页")
    private String isPage;

    @Schema(description = "常规 散车")
    private OwnTypeEnum type;


    public String getUnloadedTimeStart() {
        return timeStart(this.cycleStart);
    }

    public String getUnloadedTimeEnd() {
        return timeEnd(this.cycleEnd);
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




}
