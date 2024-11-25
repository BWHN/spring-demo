package org.example.weiyuntong.transportorder;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallgoodssource.vo.tradehall.TradeHallOrderTakeVO;
import com.weiyuntong.module.bizcenter.controller.admin.transportorder.vo.*;
import com.weiyuntong.module.bizcenter.controller.admin.waybillsource.vo.WaybillIssuedVO;
import com.weiyuntong.module.bizcenter.service.transportorder.TransportOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.*;
import java.math.BigDecimal;
import java.util.List;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 订单")
@RestController
@RequestMapping("/bizcenter/transport-order")
@Validated
public class TransportOrderController {

    @Resource
    private TransportOrderService transportOrderService;

    @PostMapping("/create")
    @Operation(summary = "创建订单")
    @PreAuthorize("@ss.hasPermission('bizcenter:transport-order:create')")
    public CommonResult<Long> createTransportOrder(@Valid @RequestBody TransportOrderCreateReqVO createReqVO) {
        return success(transportOrderService.createTransportOrder(createReqVO));
    }

    @PostMapping("/update")
    @Operation(summary = "更新订单")
    @PreAuthorize("@ss.hasPermission('bizcenter:transport-order:update')")
    public CommonResult<Boolean> updateTransportOrder(@Valid @RequestBody TransportOrderUpdateReqVO updateReqVO) {
        transportOrderService.updateTransportOrder(updateReqVO);
        return success(true);
    }

    @GetMapping("/update-detail")
    @Operation(summary = "更新订单-详情")
    public CommonResult<TransportOrderUpdateReqVO> getUpdateTransportOrderDetail(Long id) {
        TransportOrderUpdateReqVO transportOrderUpdateReqVO = transportOrderService.getUpdateTransportOrderDetail(id);
        return success(transportOrderUpdateReqVO);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除订单")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:transport-order:delete')")
    public CommonResult<Boolean> deleteTransportOrder(@RequestParam("id") Long id) {
        transportOrderService.deleteTransportOrder(id);
        return success(true);
    }

    @GetMapping("/getDesc")
    @Operation(summary = "确认运力详情")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:transport-order:query')")
    public CommonResult<TradeHallOrderTakeVO> getTransportOrderDesc(@RequestParam("id") Long id) {
        TradeHallOrderTakeVO transportOrder = transportOrderService.getTransportOrderDesc(id);
        return success(transportOrder);
    }


    @GetMapping("/detail")
    @Operation(summary = "订单详情")
    @PreAuthorize("@ss.hasPermission('bizcenter:trade-hall:order-detail')")
    public CommonResult<TaskOrderDetailVO> orderDetail(Long id) {
        return success(transportOrderService.orderDetail(id));
    }

    @GetMapping("/page")
    @Operation(summary = "获得订单分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:transport-order:query')")
    public CommonResult<PageResult<TransportOrderHomeVO>> getTransportOrderPage(@Valid TransportOrderPageReqVO pageVO) {
        return success(transportOrderService.getTransportOrderPage(pageVO));
    }

    @GetMapping("/page-count")
    @Operation(summary = "发单管理,委托单的看板统计")
    @PreAuthorize("@ss.hasPermission('bizcenter:transport-order:query')")
    public CommonResult<TransportOrderCountVO> getTransportOrderPageCount(@Valid TransportOrderPageReqVO pageVO) {
        return success(transportOrderService.getTransportOrderPageCount(pageVO));
    }

    @GetMapping("/list-count")
    @Operation(summary = "发单管理的看板统计")
    @PreAuthorize("@ss.hasPermission('bizcenter:transport-order:query')")
    public CommonResult<TransportOrderCountVO> getTransportOrderListCount(@Valid TransportOrderPageReqVO pageVO) {
        return success(transportOrderService.getTransportOrderListCount(pageVO));
    }


    @PostMapping("/sure-report-order")
    @Operation(summary = "确认报价订单")
    public CommonResult<Boolean> sureTransportOrder(@RequestBody List<Long> ids) {
        return success(transportOrderService.sureTransportOrder(ids));
    }


    @GetMapping("/stop-order")
    @Operation(summary = "结束订单")
    public CommonResult<Boolean> stopTransportOrder(Long id) {
        return success(transportOrderService.stopTransportOrder(id));
    }

    @PostMapping("/revoke-report-order")
    @Operation(summary = "批量撤销")
    public CommonResult<Boolean> revokeReportTransportOrder(@RequestBody List<Long> ids) {
        return success(transportOrderService.revokeReportTransportOrder(ids));
    }

    @PostMapping("/refused-report-order")
    @Operation(summary = "批量拒绝")
    public CommonResult<Boolean> refusedReportTransportOrder(@RequestBody List<Long> ids) {
        return success(transportOrderService.refusedReportTransportOrder(ids));
    }

    @GetMapping("/revoke-order")
    @Operation(summary = "撤销剩余重量")
    public CommonResult<Boolean> revokeTransportOrder(Long id, BigDecimal weight) {
        return success(transportOrderService.revokeTransportOrder(id,weight));
    }

    @PostMapping("/issued-order")
    @Operation(summary = "下发车辆")
    public CommonResult<Boolean> issuedTransportOrder(@RequestBody TaskWaybillVO vo) {
        return success(transportOrderService.issuedTransportOrder(vo));
    }

    @PostMapping("/issued-order-ids")
    @Operation(summary = "下发车辆")
    public CommonResult<Boolean> issuedTransportOrder(@RequestBody List<Long> ids) {
        return success(transportOrderService.issuedTransportOrder(ids));
    }

    @GetMapping("/issued-detail")
    @Operation(summary = "下发详情接口")
    public CommonResult<WaybillIssuedVO> issuedDetail(Long processId) {
        return success(transportOrderService.issuedDetail(processId));
    }

}
