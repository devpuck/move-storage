package com.wms.api.move;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.xac.core.api.SortQueryParam;

/**
 * <pre>
 * 移库单子表 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2021-01-11
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MoveWarehouseBillSubQueryParam对象", description = "移库单子表查询参数")
public class MoveWarehouseBillSubQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
