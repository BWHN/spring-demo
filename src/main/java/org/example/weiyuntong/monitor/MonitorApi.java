package org.example.weiyuntong.monitor;

import cn.hutool.json.JSONUtil;
import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.module.fleetcenter.controller.admin.monitor.vo.CarInfoVo;
import com.weiyuntong.module.fleetcenter.controller.admin.monitor.vo.DeviceGpsRecordVo;
import com.weiyuntong.module.fleetcenter.controller.admin.monitor.vo.TrackMonitorVO;
import com.weiyuntong.module.fleetcenter.service.cardesc.CarDescService;
import com.weiyuntong.module.fleetcenter.service.monitor.MonitorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;

@Tag(name = "监控中心对外接口")
@RestController
@RequestMapping("/api/fleetcenter/monitor")
@Validated
public class MonitorApi {
    @Resource
    private MonitorService monitorService;
    @Resource
    private CarDescService carDescService;

    @PostMapping("/trackMonitorv1")
    @Operation(summary = "小程序位置记录")
    //@Idempotent(timeout = 10, timeUnit = TimeUnit.SECONDS, message = "正在处理请稍等")
    public CommonResult<Boolean> trackMonitorv1(@RequestParam("gpsInfo") String repVO) {
        DeviceGpsRecordVo deviceGpsRecordVo = JSONUtil.toBean(repVO, DeviceGpsRecordVo.class);
        monitorService.createMaintenanceRecord(deviceGpsRecordVo);
        return success(true);
    }
    /*@PostMapping("/trackMonitor")
    //@Operation(summary = "小程序位置记录")
    //@Idempotent(timeout = 10, timeUnit = TimeUnit.SECONDS, message = "正在处理请稍等")
    public CommonResult<Boolean> trackMonitor(@RequestParam("carNumber") String carNumber,@RequestParam("tmStr") String tmStr,@RequestParam("lng") String lng,@RequestParam("lat") String lat,String locName,@RequestParam("speed") String speed, String direct,String sourceFlag,String mobile,String deviceNo,String userId) {
        DeviceGpsRecordVo deviceGpsRecordVo = new DeviceGpsRecordVo();
        deviceGpsRecordVo.setTmStr(tmStr);
        deviceGpsRecordVo.setLng(lng);
        deviceGpsRecordVo.setLat(lat);
        deviceGpsRecordVo.setLocName(locName);
        deviceGpsRecordVo.setSpeed(speed);
        deviceGpsRecordVo.setDeviceNo(deviceNo);
        deviceGpsRecordVo.setMobile(mobile);
        deviceGpsRecordVo.setCarNumber(carNumber);
        deviceGpsRecordVo.setSourceFlag("WeChat");
        deviceGpsRecordVo.setDirect(direct);
        monitorService.createMaintenanceRecordAPi(deviceGpsRecordVo);
        return success(true);
    }*/

    @PostMapping("/trackMonitor")
    //@Operation(summary = "小程序位置记录")
    //@Idempotent(timeout = 10, timeUnit = TimeUnit.SECONDS, message = "正在处理请稍等")
    public CommonResult<Boolean> trackMonitor(@RequestBody TrackMonitorVO trackMonitorVO) {
        DeviceGpsRecordVo deviceGpsRecordVo = new DeviceGpsRecordVo();
        deviceGpsRecordVo.setTmStr(trackMonitorVO.getTmStr());
        deviceGpsRecordVo.setLng(trackMonitorVO.getLng());
        deviceGpsRecordVo.setLat(trackMonitorVO.getLat());
        deviceGpsRecordVo.setLocName(trackMonitorVO.getLocName());
        deviceGpsRecordVo.setSpeed(trackMonitorVO.getSpeed());
        deviceGpsRecordVo.setDeviceNo(trackMonitorVO.getOpenId());
        deviceGpsRecordVo.setMobile(trackMonitorVO.getMobile());
        deviceGpsRecordVo.setCarNumber(trackMonitorVO.getCarNumber());
        deviceGpsRecordVo.setSourceFlag("WeChat");
        deviceGpsRecordVo.setDirect(trackMonitorVO.getDirect());
        monitorService.createMaintenanceRecordAPi(deviceGpsRecordVo);
        return success(true);
    }

    @GetMapping("/getCarNumberByDriverMobile")
    @Operation(summary = "根据司机手机号获取车牌号")
    @Parameter(name = "mobile", description = "手机号", required = true, example = "18654607777")
    public CommonResult<CarInfoVo> getCarNumberByDriverMobile(@RequestParam("mobile") String mobile) {
        return success(carDescService.getCarNumberByDriverMobile(mobile));
    }

    @PostMapping("/getCarNumberAndDriverInfoByDriverMobile")
    @Operation(summary = "根据司机手机号获取车牌号")
    @Parameter(name = "mobile", description = "手机号", required = true, example = "18654607777")
    public CommonResult<String> getCarNumberAndDriverInfoByDriverMobile(@RequestParam("mobile") String mobile) {
        return success(carDescService.getCarNumberAndDriverInfoByDriverMobile(mobile));
    }

    public static void main(String[] args) {
        System.out.println(Timestamp.valueOf(LocalDateTime.now()).getTime());
    }
}
