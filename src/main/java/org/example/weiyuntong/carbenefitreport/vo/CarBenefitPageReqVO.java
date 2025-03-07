package org.example.weiyuntong.carbenefitreport.vo;

import com.weiyuntong.module.system.service.permission.dto.RoleDataDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * 自营车辆效益 分页查询条件
 */

@Data
public class CarBenefitPageReqVO extends RoleDataDTO {

    @Schema(description = "统计周期 年/月")
    private String cycle;

    @Schema(description = "会计周期")
    private String cycleStart;
    private String cycleEnd;

    @Schema(description = "车牌号")
    private String carNumber;

    @Schema(description = "车辆归属 1自有/2租赁")
    private Integer carBelong;

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
