package org.example.weiyuntong.monitor;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.module.fleetcenter.service.monitor.GoodsCarSourceMonitorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;

@Tag(name = "监控中心 - 车源与货源地图监控")
@RestController
@RequestMapping("/fleetcenter/goods-carsource")
@Validated
public class GoodsCarSourceMonitorController {
    @Resource
    GoodsCarSourceMonitorService goodsCarMonitorService;
    @PostMapping("/addressDetailList")
    @Operation(summary = "获取地址详情list")
    public CommonResult<Map<String, List<Map<String, Object>>>> addressDetailList(@RequestBody Map<String, Object> paramMap) {
        return success(goodsCarMonitorService.addressDetailList(paramMap));
    }
    @PostMapping("/carSourceCityCount")
    @Operation(summary = "车源城市统计list")
    public CommonResult<List<Map<String, Object>>> carSourceCityCount() {
        return success(goodsCarMonitorService.carSourceCityCount(new HashMap<>()));
    }

}
