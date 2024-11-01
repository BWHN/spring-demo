package org.example.weiyuntong.carconfig;

import cn.hutool.json.JSONUtil;
import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.web.core.util.WebFrameworkUtils;
import com.weiyuntong.module.bizcenter.controller.admin.carconfig.vo.*;
import com.weiyuntong.module.bizcenter.controller.admin.transporttaskentrustorder.vo.TransportTaskEntrustorderUpdateReqVO;
import com.weiyuntong.module.bizcenter.convert.carconfig.CarConfigConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.transporttaskassign.TransportTaskAssignDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.transporttaskentrustorder.TransportTaskEntrustorderDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.transporttaskmatch.TransportTaskMatchDO;
import com.weiyuntong.module.bizcenter.service.carconfig.CarConfigService;
import com.weiyuntong.module.bizcenter.service.transporttaskentrustorder.TransportTaskEntrustorderService;
import com.weiyuntong.module.fleetcenter.dal.dataobject.carconfig.CarConfigDO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.*;
import java.util.List;

import static com.weiyuntong.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.*;
import static com.weiyuntong.module.system.enums.ErrorCodeConstants.NOT_CAR_COST_CONFIG;


@Tag(name = "管理后台 - 车辆费用配置")
@RestController
@RequestMapping("/fleet/car-config")
@Validated
public class CarConfigController {

    @Resource
    private CarConfigService carConfigService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private TransportTaskEntrustorderService transportTaskEntrustorderService;

    @PutMapping("/save")
    @Operation(summary = "更新车辆费用配置")
    public CommonResult<Boolean> updateCarConfig(@Valid @RequestBody CarConfigUpdateReqVO updateReqVO) {
        carConfigService.updateCarConfig(updateReqVO);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得车辆费用配置")
    public CommonResult<CarConfigRespVO> getCarConfig() {
        CarConfigDO carConfig = carConfigService.getCarConfig(null);
        if (carConfig == null) {
            carConfig = new CarConfigDO();
        }
        return success(CarConfigConvert.INSTANCE.convert(carConfig));
    }

    @PostMapping("/getProfitAmount")
    @Operation(summary = "预计毛利润")
    public CommonResult getProfitAmount(@RequestBody ProfitAmountReqVO reqVO) {
        List<TransportTaskMatchDO> taskMatchList = reqVO.getTaskMatchList();
        taskMatchList.forEach(i -> {
            CarConfigDO carConfig = carConfigService.getCarConfig(i.getEntId());
            if (carConfig == null && WebFrameworkUtils.getTenantId().equals(i.getEntId())) {
                throw exception(NOT_CAR_COST_CONFIG);
            }
        });
        return success(carConfigService.getProfit_Amount(reqVO));
    }

    @PostMapping("/getProfitAmountReceiveOrder")
    @Operation(summary = "预计毛利润")
    public CommonResult getProfitAmountReceiveOrder(@RequestBody TransportTaskEntrustorderUpdateReqVO reqVO) {
        List<TransportTaskAssignDO> taskAssignList = reqVO.getTransportTaskAssignDoList();
        taskAssignList.forEach(i -> {
            CarConfigDO carConfig = carConfigService.getCarConfig(i.getCarrierId());
            if (carConfig == null) {
                throw exception(NOT_CAR_COST_CONFIG);
            }
        });
        TransportTaskEntrustorderDO transportTaskEntrustorder = transportTaskEntrustorderService.getTransportTaskEntrustorder(reqVO.getId());
        ProfitAmountReqVO profitAmountReqVO = transportTaskEntrustorderService.getProfitAmountReqVO(transportTaskEntrustorder, reqVO.getTransportTaskAssignDoList());
        String config = stringRedisTemplate.opsForValue().get(reqVO.getId().toString());
        if (config != null) {
            CarConfigProfitVO carConfigProfitVO = JSONUtil.toBean(config, CarConfigProfitVO.class);
            profitAmountReqVO.setCarConfigProfit(carConfigProfitVO);
        }
        return success(carConfigService.getProfitAmountReceiveOrder(profitAmountReqVO, transportTaskEntrustorder));
    }

    @PostMapping("/getPathPlan")
    @Operation(summary = "查询高速信息")
    public CommonResult getPathPlan(@RequestBody PathPlanReqVO reqVO) {
        return success(carConfigService.getPathPlan(reqVO.getStartGps(), reqVO.getEndGps()));
    }

    @GetMapping("/getDefaultCarConfig")
    @Operation(summary = "获得默认车辆费用配置")
    public CommonResult<CarConfigRespVO> getDefaultCarConfig() {
        CarConfigDO carConfig = carConfigService.getDefaultCarConfig();
        if (carConfig == null) {
            carConfig = new CarConfigDO();
        }
        return success(CarConfigConvert.INSTANCE.convert(carConfig));
    }

}
