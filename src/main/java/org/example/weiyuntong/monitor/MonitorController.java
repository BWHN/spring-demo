package org.example.weiyuntong.monitor;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.util.string.StringUtil;
import com.weiyuntong.framework.idempotent.core.annotation.Idempotent;
import com.weiyuntong.module.fleetcenter.controller.admin.monitor.vo.DeviceGpsRecordVo;
import com.weiyuntong.module.fleetcenter.service.monitor.MonitorService;
import com.weiyuntong.module.system.service.address.MyAddressService;
import com.weiyuntong.module.system.service.tenant.TenantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;

@Tag(name = "监控中心 - 车辆监控")
@RestController
@RequestMapping("/fleetcenter/monitor")
@Validated
public class MonitorController {
    @Resource
    MonitorService monitorService;
    @Resource
    private TenantService tenantService;
    @Resource
    private MyAddressService myAddressService;

    @PostMapping("/create")
    @Operation(summary = "创建轨迹记录")
    @Idempotent(timeout = 10, timeUnit = TimeUnit.SECONDS, message = "坐标信息正在处理中，请勿重复提交")
    @PreAuthorize("@ss.hasPermission('fleetcenter:monitor-record:create')")
    public CommonResult<Long> create(@Valid @RequestBody DeviceGpsRecordVo record) {
        return success(monitorService.createMaintenanceRecord(record));
    }
    @PostMapping("/queryGpsMapByCarNo")
    @Operation(summary = "查询单辆车实时gps数据及物流信息")
    public CommonResult<Map<String, Object>> queryGpsMapByCarNo(@RequestBody Map<String, Object> paramMap) {
        String carNo = StringUtil.trimNull(paramMap.get("carNo"));
        return success(monitorService.getCarGpsDataByCarNo(carNo));
    }


    @PostMapping("/getCarGpsByEntId")
    @Operation(summary = "查询当前企业下车辆gps数据")
    @PreAuthorize("@ss.hasPermission('fleetcenter:monitor-gps-record:get')")
    public CommonResult<List<Map<String, Object>>> getCarGpsByEntId(@Valid @RequestParam("entId") Long entId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("tenantId",entId);
        return success(monitorService.getCarGpsByEntId(paramMap));
    }

    @PostMapping("/listGpsMap")
    @Operation(summary = "位置看板-查看车辆GPS")
    public CommonResult<Map<String, Object>> listGpsMap(@RequestBody Map<String, Object> paramMap) {
        return success(monitorService.getAllCarGpsData(paramMap));
    }

    @PostMapping("/getCarGpsByParamMap")
    @Operation(summary = "查询当前企业下车辆gps数据-支持多参数")
    @PreAuthorize("@ss.hasPermission('fleetcenter:monitor-gps-record:get')")
    public CommonResult<List<Map<String, Object>>> getCarGpsByParamMap(@RequestBody Map<String, Object> paramMap) {
        return success(monitorService.getCarGpsByParamMap(paramMap));
    }
    @PostMapping("/listGpsHisByCarNo")
    @Operation(summary = "查询车辆历史轨迹记录信息")
    //@PreAuthorize("@ss.hasPermission('fleetcenter:monitor-gps-record:get')")
    public CommonResult<List<Map<String, Object>>> getCarGpsHisData(@RequestBody Map<String, Object> paramMap) {

        return success(monitorService.getCarGpsHisData(paramMap));
    }
    @PostMapping("/listSelectPageAll")
    @Operation(summary = "位置地图-查询所有企业")
    public CommonResult<List<Map<String, Object>>> listSelectPageAll( Map<String, Object> paramMap) {
        List<Map<String, Object>>  enterpriseList =monitorService.getTenantInfo(paramMap);
        return success(enterpriseList);
    }

    @PostMapping("/addressTypeList")
    @Operation(summary = "获取监控中所需的地址类型")
    public CommonResult<List<Map<String, Object>>> addressTypeList() {
        List<Map<String, Object>>  addressList =monitorService.addressTypeList();
        return success(addressList);
    }
    @PostMapping("/addressList")
    @Operation(summary = "根据地址类型获取地址")
    public CommonResult<Map<String, List<Map<String, Object>>>> addressList(@RequestBody Map<String, Object> paramMap) {
        return success(monitorService.addressList(paramMap));
    }


    @PostMapping("/listCarCurrentLocationInfo")
    @Operation(summary = "获取车辆位置")
    public CommonResult<List<Map<String, Object>>> listCarCurrentLocationInfo( @RequestBody Map<String, Object> paramMap) {
        return success(monitorService.listCarCurrentLocationInfo(paramMap));
    }


    @GetMapping("/getGpsInfo")
    @Operation(summary = "获取GPS信息")
    public CommonResult<Object> getGpsInfo(String carNo) {
        return success(monitorService.getCurrentGps(carNo));
    }
}
