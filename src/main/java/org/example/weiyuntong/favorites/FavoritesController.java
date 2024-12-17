package org.example.weiyuntong.favorites;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.favorites.vo.*;
import com.weiyuntong.module.bizcenter.convert.favorites.FavoritesConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.favorites.FavoritesDO;
import com.weiyuntong.module.bizcenter.service.favorites.FavoritesService;
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

@Tag(name = "管理后台 - 收藏夹")
@RestController
@RequestMapping("/bizcenter/favorites")
@Validated
public class FavoritesController {

    @Resource
    private FavoritesService favoritesService;

    @PostMapping("/create")
    @Operation(summary = "创建收藏夹")
    @PreAuthorize("@ss.hasPermission('bizcenter:favorites:create')")
    public CommonResult<Long> createFavorites(@Valid @RequestBody FavoritesCreateReqVO createReqVO) {
        return success(favoritesService.createFavorites(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新收藏夹")
    @PreAuthorize("@ss.hasPermission('bizcenter:favorites:update')")
    public CommonResult<Boolean> updateFavorites(@Valid @RequestBody FavoritesUpdateReqVO updateReqVO) {
        favoritesService.updateFavorites(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除收藏夹")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:favorites:delete')")
    public CommonResult<Boolean> deleteFavorites(@RequestParam("id") Long id) {
        favoritesService.deleteFavorites(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得收藏夹")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:favorites:query')")
    public CommonResult<FavoritesRespVO> getFavorites(@RequestParam("id") Long id) {
        FavoritesDO favorites = favoritesService.getFavorites(id);
        return success(FavoritesConvert.INSTANCE.convert(favorites));
    }

    @GetMapping("/list")
    @Operation(summary = "获得收藏夹列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:favorites:query')")
    public CommonResult<List<FavoritesRespVO>> getFavoritesList(@RequestParam("ids") Collection<Long> ids) {
        List<FavoritesDO> list = favoritesService.getFavoritesList(ids);
        return success(FavoritesConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得收藏夹分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:favorites:query')")
    public CommonResult<PageResult<FavoritesRespVO>> getFavoritesPage(@Valid FavoritesPageReqVO pageVO) {
        PageResult<FavoritesDO> pageResult = favoritesService.getFavoritesPage(pageVO);
        return success(FavoritesConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出收藏夹 Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:favorites:export')")
    @OperateLog(type = EXPORT)
    public void exportFavoritesExcel(@Valid FavoritesExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<FavoritesDO> list = favoritesService.getFavoritesList(exportReqVO);
        // 导出 Excel
        List<FavoritesExcelVO> datas = FavoritesConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "收藏夹.xls", "数据", FavoritesExcelVO.class, datas);
    }

}
