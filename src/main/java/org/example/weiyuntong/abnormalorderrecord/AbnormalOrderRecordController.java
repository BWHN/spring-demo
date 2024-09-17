package org.example.weiyuntong.abnormalorderrecord;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.abnormalorderassign.vo.AbnormalOrderAssignBaseVO;
import com.weiyuntong.module.bizcenter.controller.admin.abnormalorderassign.vo.AbnormalOrderAssignCreateReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.abnormalorderfollow.vo.AbnormalOrderFollowCreateReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.abnormalorderrecord.vo.*;
import com.weiyuntong.module.bizcenter.convert.abnormalorderrecord.AbnormalOrderRecordConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.abnormalorderrecord.AbnormalOrderRecordDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.transporttaskentrustorder.TransportTaskEntrustorderDO;
import com.weiyuntong.module.bizcenter.service.abnormalorderassign.AbnormalOrderAssignService;
import com.weiyuntong.module.bizcenter.service.abnormalorderfollow.AbnormalOrderFollowService;
import com.weiyuntong.module.bizcenter.service.abnormalorderrecord.AbnormalOrderRecordService;
import com.weiyuntong.module.bizcenter.service.tradehallgoodssource.TransportGoodsEntrustorderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.*;

@Tag(name = "运营中心-异常管理-委托失效记录")
@RestController
@RequestMapping("/bizcenter/abnormal-order-record")
@Validated
public class AbnormalOrderRecordController {

    @Resource
    private AbnormalOrderRecordService abnormalOrderRecordService;
    @Resource
    private AbnormalOrderAssignService abnormalOrderAssignService;
    @Resource
    private AbnormalOrderFollowService abnormalOrderFollowService;
    @Resource
    private TransportGoodsEntrustorderService transportGoodsEntrustorderService;

    @PostMapping("/create")
    @Operation(summary = "创建委托失效记录")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-record:create')")
    public CommonResult<Long> createAbnormalOrderRecord(@Valid @RequestBody AbnormalOrderRecordCreateReqVO createReqVO) {
        return success(abnormalOrderRecordService.createAbnormalOrderRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新委托失效记录")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-record:update')")
    public CommonResult<Boolean> updateAbnormalOrderRecord(@Valid @RequestBody AbnormalOrderRecordUpdateReqVO updateReqVO) {
        abnormalOrderRecordService.updateAbnormalOrderRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除委托失效记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-record:delete')")
    public CommonResult<Boolean> deleteAbnormalOrderRecord(@RequestParam("id") Long id) {
        abnormalOrderRecordService.deleteAbnormalOrderRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得委托失效记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-record:query')")
    public CommonResult<AbnormalOrderRecordRespVO> getAbnormalOrderRecord(@RequestParam("id") Long id) {
        AbnormalOrderRecordDO abnormalOrderRecord = abnormalOrderRecordService.getAbnormalOrderRecord(id);
        return success(AbnormalOrderRecordConvert.INSTANCE.convert(abnormalOrderRecord));
    }

    @GetMapping("/list")
    @Operation(summary = "获得委托失效记录列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-record:query')")
    public CommonResult<List<AbnormalOrderRecordRespVO>> getAbnormalOrderRecordList(@RequestParam("ids") Collection<Long> ids) {
        List<AbnormalOrderRecordDO> list = abnormalOrderRecordService.getAbnormalOrderRecordList(ids);
        return success(AbnormalOrderRecordConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得委托失效记录分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-record:query')")
    public CommonResult<PageResult<AbnormalOrderRecordRespVO>> getAbnormalOrderRecordPage(@Valid AbnormalOrderRecordPageReqVO pageVO) {
        PageResult<AbnormalOrderRecordDO> pageResult = abnormalOrderRecordService.getAbnormalOrderRecordPageJoin(pageVO);
        PageResult<AbnormalOrderRecordRespVO> respVOPageResult = AbnormalOrderRecordConvert.INSTANCE.convertPage(pageResult);
        for (AbnormalOrderRecordRespVO item : respVOPageResult.getList()) {
            TransportTaskEntrustorderDO transportTaskEntrustorderDO = transportGoodsEntrustorderService.getTransportTaskEntrustOrderSingle(item.getAssociatedId());
            if (null != item.setTransportTaskEntrustOrderDO(transportTaskEntrustorderDO)) {
                item.setTransportTaskEntrustOrderDO(transportTaskEntrustorderDO);
            }
            item.setFollowCount(abnormalOrderFollowService.getAbnormalOrderFollowCount(item.getId()));
        }
        return success(respVOPageResult);
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出委托失效记录 Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-record:export')")
    @OperateLog(type = EXPORT)
    public void exportAbnormalOrderRecordExcel(@Valid AbnormalOrderRecordExportReqVO exportReqVO,
                                               HttpServletResponse response) throws IOException {
        List<AbnormalOrderRecordDO> list = abnormalOrderRecordService.getAbnormalOrderRecordList(exportReqVO);
        // 导出 Excel
        List<AbnormalOrderRecordExcelVO> datas = AbnormalOrderRecordConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "委托失效记录.xls", "数据", AbnormalOrderRecordExcelVO.class, datas);
    }

    @PostMapping("/assign")
    @Operation(summary = "失效记录分配")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-record:assign')")
    public CommonResult<Boolean> assign(@Valid @RequestBody AbnormalOrderAssignCreateReqVO createReqVO) {
        abnormalOrderAssignService.abnormalOrderAssign(createReqVO);
        return success(true);
    }

    @PostMapping("/follow")
    @Operation(summary = "失效记录跟进")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-record:follow')")
    public CommonResult<Long> follow(@Valid @RequestBody AbnormalOrderFollowCreateReqVO createReqVO) {
        return success(abnormalOrderFollowService.createAbnormalOrderFollow(createReqVO));
    }

    @GetMapping("/getInfo")
    @Operation(summary = "详情")
    public CommonResult<AbnormalOrderAssignBaseVO> getInfo(@RequestParam("id") Long id) {
        return success(abnormalOrderFollowService.getInfo(id));
    }
}
