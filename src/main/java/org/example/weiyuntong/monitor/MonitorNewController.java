package org.example.weiyuntong.monitor;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.module.fleetcenter.controller.admin.monitor.vo.MonitorCarVO;
import com.weiyuntong.module.fleetcenter.controller.admin.monitor.vo.MonitorGpsRequestVO;
import com.weiyuntong.module.fleetcenter.service.monitor.MonitorNewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;

@Tag(name = "监控中心 - 车辆监控")
@RestController
@RequestMapping("/fleetcenter/new/monitor")
@Validated
public class MonitorNewController {
    @Resource
    private MonitorNewService monitorNewService;

    @PostMapping("/listGpsMap")
    @Operation(summary = "位置看板-查看车辆GPS")
    public CommonResult<Map<String, Object>> listGpsMap(@RequestBody MonitorGpsRequestVO pageVO) {
        return success(monitorNewService.getAllCarGpsData(pageVO));
    }

    @GetMapping("/get-car")
    @Operation(summary = "位置看板-车辆监控面板")
    public CommonResult<MonitorCarVO> getCarInfo(String carNumber) {
        return success(monitorNewService.getCarInfo(carNumber));
    }

}
