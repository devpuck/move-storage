package com.wms.api.move;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.xac.core.api.SortQueryParam;

/**
 * <pre>
 * 移库表 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-22
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "MoveWarehouseBillQueryParam对象", description = "移库表查询参数")
public class MoveWarehouseBillQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
