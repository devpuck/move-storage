package com.wms.api.move;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.xac.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 移库表 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-22
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "MoveWarehouseBillVo对象", description = "移库表查询参数")
public class MoveWarehouseBillVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表id")
    private Long id;

    @ApiModelProperty(value = "移出库房编码")
    private String moveOutWarehouseCode;

    @ApiModelProperty(value = "移出库房编码")
    private String moveInWarehouseCode;

    @ApiModelProperty(value = "移库单号")
    private String billCode;

    @ApiModelProperty(value = "出库单号，自动创建")
    private String moveOutBillCode;

    @ApiModelProperty(value = "入库单号，自动创建")
    private String moveInBillCode;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "是否需要质检")
    private String needQuality;

    @ApiModelProperty(value = "质检后处理状态，主要是不合格如何处理，如退回原库，还是转移到原库")
    private String qualityCategory;

private String version;

private String note;

}
