package com.wms.api.move;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.xac.core.api.SortQueryParam;

/**
 * <pre>
 * 移动相关质检单据管理 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-22
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MoveWarehouseQualityResultQueryParam对象", description = "移动相关质检单据管理查询参数")
public class MoveWarehouseQualityResultQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
