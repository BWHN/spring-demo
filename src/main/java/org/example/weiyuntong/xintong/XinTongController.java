package org.example.weiyuntong.xintong;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.module.bizcenter.api.xintong.vo.*;
import com.weiyuntong.module.bizcenter.service.tradehallgoodssource.TradeHallService;
import com.weiyuntong.module.bizcenter.service.transportorder.TransportOrderService;
import com.weiyuntong.module.bizcenter.service.waybillsource.WaybillSourceService;
import com.weiyuntong.module.fleetcenter.controller.admin.ordinarycarrier.vo.EnterpriseDTO;
import com.weiyuntong.module.fleetcenter.service.ordinarycarrier.OrdinaryCarrierNewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


@Tag(name = "三方平台调用 - 星通北斗")
@RestController
@RequestMapping("/bizcenter/api")
public class XinTongController {

    @Resource
    private TransportOrderService transportOrderService;
    @Resource
    private WaybillSourceService waybillSourceService;
    @Resource
    private OrdinaryCarrierNewService ordinaryCarrierNewService;
    @Resource
    private TradeHallService tradeHallService;

    @PostMapping("/orderCheckCall")
    @Operation(summary = "订单审核回调")
    public CommonResult<?> orderCheckCall(@Valid @RequestBody XinTongOrderCallBackRequest request) {
        return transportOrderService.orderCheckCall(request);
    }

    @PostMapping("/showCarrier")
    @Operation(summary = "司机接单展示承运商")
    public CommonResult<List<EnterpriseDTO>> showCarrier(@Valid @RequestBody XinTongShowCarrierRequest request) {
        return ordinaryCarrierNewService.getOrderCarrier(request);
    }

    @PostMapping("/quote")
    @Operation(summary = "司机扫码接单")
    public CommonResult<XinTongQuoteResponse> quote(HttpServletRequest request, @Valid @RequestBody XinTongQuoteRequest quoteRequest) {
        return tradeHallService.quote(request, quoteRequest);
    }

    @PostMapping("/waybillCheckCallBack")
    @Operation(summary = "下游运单审核回调")
    public CommonResult<?> waybillCheckCallBack(@RequestBody XinTongWaybillVerifyCallBackRequest vo) {
        return waybillSourceService.xinTongWaybillCheckCallBack(vo);
    }

    @PostMapping("/changeWaybillStatusCallBack")
    @Operation(summary = "运单状态变更回调")
    public CommonResult<?> changeWaybillStatusCallBack(@RequestBody XinTongWaybillStatusChangeCallBackRequest vo
            , HttpServletRequest request) {
        return waybillSourceService.xinTongchangeWaybillStatusCallBack(vo,request);
    }

}
