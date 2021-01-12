package com.wms.api.move;

import com.wms.api.account.AccountVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.xac.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * 移库单子表 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2021-01-11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "MoveWarehouseBillSubVo对象", description = "移库单子表查询参数")
public class MoveWarehouseBillSubVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表id")
    private Long id;

    @ApiModelProperty(value = "移库单编号")
    private String billCode;

    @ApiModelProperty(value = "移库前台账ID")
    private AccountVo accountVo;

    @ApiModelProperty(value = "移入库房库位号")
    private String inWarehouseLocationCode;

    @ApiModelProperty(value = "移库前项目编码")
    private String beforeProjectCode;

    @ApiModelProperty(value = "移库后项目编码")
    private String endProjectCode;

    @ApiModelProperty(value = "移库前价格")
    private BigDecimal beforePrice;

    @ApiModelProperty(value = "移库后价格")
    private BigDecimal endPrice;

    @ApiModelProperty(value = "移库前价格策略")
    private BigDecimal beforePriceCategory;

    @ApiModelProperty(value = "移库后价格策略")
    private BigDecimal endPriceCategory;

    @ApiModelProperty(value = "移动数量")
    private BigDecimal moveQuantity;

    @ApiModelProperty(value = "移动质检消耗数量")
    private BigDecimal moveQualityConsumeQuantity;

    @ApiModelProperty(value = "状态")
    private String status;

}
