package org.example.weiyuntong.carbenefitreport;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.idempotent.core.annotation.Idempotent;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.datacenter.controller.admin.carbenefitreport.vo.*;
import com.weiyuntong.module.datacenter.service.carbenefitreport.CarBenefitReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 自营车辆效益 运力支出 车队成本
 */

@Tag(name = "报表管理")
@RestController
@RequestMapping("/datacenter/carBenefit")
@Validated
public class CarBenefitReportController {

    @Resource
    private CarBenefitReportService carBenefitReportService;


    /**
     * 自营车辆效益
     * @param pageParam
     * @return
     */
    @PostMapping("/getCarBenefitPage")
    public CommonResult<PageResult<CarBenefitPageVO>> getCarBenefitPage(@RequestBody CarBenefitPageReqVO pageParam) {
        return success(carBenefitReportService.getCarBenefitPage(pageParam));
    }

    /**
     * 自营车辆效益看板数据
     * @param pageParam
     * @return
     */
    @PostMapping("/getCarBenefitCount")
    public CommonResult<CarBenefitCount> getCarBenefitCount(@RequestBody CarBenefitPageReqVO pageParam) {
        return success(carBenefitReportService.getCarBenefitCount(pageParam));
    }


    /**
     * 自营车辆效益 数据图
     * @param pageParam
     * @return
     */
    @PostMapping("/getCarBenefitDataMap")
    public CommonResult<CarBenefitDataMapVO> getCarBenefitDataMap(@RequestBody CarBenefitPageReqVO pageParam) {
        return success(carBenefitReportService.getCarBenefitDataMap(pageParam));
    }


    @PostMapping(value = "/carBenefitData-exportExcel")
    @Idempotent(timeout = 10, timeUnit = SECONDS, message = "正在处理请稍等")
    public void exportCarBenefitExcel(@RequestBody CarBenefitPageReqVO pageParam, HttpServletResponse response) throws Exception {
        pageParam.setIsPage("1");
        carBenefitReportService.exportCarBenefiteExcel(pageParam,response);
    }


    /**
     *  运力支出 - 分页
     */
    @PostMapping("/getCapacityExpenditurePage")
    public CommonResult<PageResult<CapacityExpenditurePageVO>> getCapacityExpenditurePage(@RequestBody CapacityExpenditurePageReqVO pageParam) {
        return success(carBenefitReportService.getCapacityExpenditurePage(pageParam));
    }

    /**
     * 运力支出  - 数据看板
     * @param pageParam
     * @return
     */
    @PostMapping("/capacityExpenditureCount")
    public CommonResult<CapacityExpenditureCount> capacityExpenditureCount(@RequestBody CapacityExpenditurePageReqVO pageParam) {
        return success(carBenefitReportService.capacityExpenditureCount(pageParam));
    }


    @PostMapping(value = "/capacityExpenditure-exportExcel")
    @Idempotent(timeout = 10, timeUnit = SECONDS, message = "正在处理请稍等")
    public void exportCapacityExpenditureExcel(@RequestBody CapacityExpenditurePageReqVO pageParam, HttpServletResponse response) throws Exception {
        pageParam.setIsPage("1");
        carBenefitReportService.exportCapacityExpenditureExcel(pageParam , response);
    }




    /**
     * 车队成本 - car
     */
    @PostMapping("/getFleetCostByCarPage")
    public CommonResult<PageResult<FleetCostByCarPageVO>> getFleetCostByCarPage(@RequestBody FleetCostReqVO pageParam) {
        return success(carBenefitReportService.getFleetCostByCarPage(pageParam));
    }

    @GetMapping("/fleetCostByCar-exportExcel")
    @Operation(summary = "导出车队成本 -car Excel")
    @OperateLog(type = EXPORT)
    @Idempotent(timeout = 10, timeUnit = SECONDS, message = "正在处理请稍等")
    public void exportFleetCostByCar(@Valid FleetCostReqVO pageParam,
                                      HttpServletResponse response) throws IOException {
        pageParam.setIsPage("1");
        List<FleetCostByCarPageVO> datas = carBenefitReportService.getFleetCostByCarPage(pageParam).getList();
        ExcelUtils.write(response, "车队成本表-车辆.xls", "数据", FleetCostByCarPageVO.class, datas);
    }


    /**
     * 车队成本 看板数据统计
     * @param pageParam
     * @return
     */
    @PostMapping("/getFleetCostCount")
    public CommonResult<FleetAndExpenseCostCountVO> getFleetCostCount(@RequestBody FleetCostReqVO pageParam) {
        return success(carBenefitReportService.getFleetCostCount(pageParam));
    }


    /**
     * 车队成本 - driver
     */
    @PostMapping("/getFleetCostByDriverPage")
    public CommonResult<PageResult<FleetCostByDriverPageVO>> getFleetCostByDriverPage(@RequestBody FleetCostReqVO pageParam) {
        return success(carBenefitReportService.getFleetCostByDriverPage(pageParam));
    }

    @GetMapping("/fleetCostByDriver-exportExcel")
    @Operation(summary = "导出车队成本 -driver Excel")
    @OperateLog(type = EXPORT)
    @Idempotent(timeout = 10, timeUnit = SECONDS, message = "正在处理请稍等")
    public void exportFleetCostByDriver(@Valid FleetCostReqVO pageParam,
                                     HttpServletResponse response) throws IOException {
        pageParam.setIsPage("1");
        List<FleetCostByDriverPageVO> datas = carBenefitReportService.getFleetCostByDriverPage(pageParam).getList();
        ExcelUtils.write(response, "车队成本表-驾驶员.xls", "数据", FleetCostByDriverPageVO.class, datas);
    }








}
