package org.example.weiyuntong.linkrecord;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.module.bizcenter.controller.admin.linkrecord.vo.*;
import com.weiyuntong.module.bizcenter.convert.linkrecord.LinkRecordConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.linkrecord.LinkRecordDO;
import com.weiyuntong.module.bizcenter.service.linkrecord.LinkRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.*;
import javax.validation.constraints.*;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.*;

@Tag(name = "运营中心 - 承运商或货主关联")
@RestController
@RequestMapping("/bizcenter/link-record")
@Validated
public class LinkRecordController {

    @Resource
    private LinkRecordService linkRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建承运商或货主关联")
    @PreAuthorize("@ss.hasPermission('bizcenter:link-record:create')")
    public CommonResult<Boolean> createLinkRecord(@Valid @RequestBody LinkRecordCreateReqVO createReqVO) {
        return success(linkRecordService.createLinkRecord(createReqVO));
    }

    @GetMapping("/page")
    @Operation(summary = "获得承运商或货主关联分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:link-record:query')")
    public CommonResult<PageResult<LinkRecordRespVO>> getLinkRecordPage(@Valid LinkRecordPageReqVO pageVO) {
        PageResult<LinkRecordDO> pageResult = linkRecordService.getLinkRecordPage(pageVO);
        return success(LinkRecordConvert.INSTANCE.convertPage(pageResult));
    }
//
//    @PutMapping("/update")
//    @Operation(summary = "更新承运商或货主关联")
//    @PreAuthorize("@ss.hasPermission('bizcenter:link-record:update')")
//    public CommonResult<Boolean> updateLinkRecord(@Valid @RequestBody LinkRecordUpdateReqVO updateReqVO) {
//        linkRecordService.updateLinkRecord(updateReqVO);
//        return success(true);
//    }
//
    @DeleteMapping("/delete")
    @Operation(summary = "删除承运商或货主关联")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:link-record:delete')")
    public CommonResult<Boolean> deleteLinkRecord(@RequestParam("id") Long id) {
        linkRecordService.deleteLinkRecord(id);
        return success(true);
    }
//
//    @GetMapping("/get")
//    @Operation(summary = "获得承运商或货主关联")
//    @Parameter(name = "id", description = "编号", required = true, example = "1024")
//    @PreAuthorize("@ss.hasPermission('bizcenter:link-record:query')")
//    public CommonResult<LinkRecordRespVO> getLinkRecord(@RequestParam("id") Long id) {
//        LinkRecordDO linkRecord = linkRecordService.getLinkRecord(id);
//        return success(LinkRecordConvert.INSTANCE.convert(linkRecord));
//    }
//
//    @GetMapping("/list")
//    @Operation(summary = "获得承运商或货主关联列表")
//    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
//    @PreAuthorize("@ss.hasPermission('bizcenter:link-record:query')")
//    public CommonResult<List<LinkRecordRespVO>> getLinkRecordList(@RequestParam("ids") Collection<Long> ids) {
//        List<LinkRecordDO> list = linkRecordService.getLinkRecordList(ids);
//        return success(LinkRecordConvert.INSTANCE.convertList(list));
//    }
//
//
//
//    @GetMapping("/export-excel")
//    @Operation(summary = "导出承运商或货主关联 Excel")
//    @PreAuthorize("@ss.hasPermission('bizcenter:link-record:export')")
//    @OperateLog(type = EXPORT)
//    public void exportLinkRecordExcel(@Valid LinkRecordExportReqVO exportReqVO,
//              HttpServletResponse response) throws IOException {
//        List<LinkRecordDO> list = linkRecordService.getLinkRecordList(exportReqVO);
//        // 导出 Excel
//        List<LinkRecordExcelVO> datas = LinkRecordConvert.INSTANCE.convertList02(list);
//        ExcelUtils.write(response, "承运商或货主关联.xls", "数据", LinkRecordExcelVO.class, datas);
//    }

}
