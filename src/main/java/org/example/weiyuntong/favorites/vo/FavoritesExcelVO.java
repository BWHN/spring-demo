package org.example.weiyuntong.favorites.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 收藏夹 Excel VO
 *
 * @author 维运通
 */
@Data
public class FavoritesExcelVO {

    @ExcelProperty("任务ID")
    private Long taskEntrustOrderId;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
