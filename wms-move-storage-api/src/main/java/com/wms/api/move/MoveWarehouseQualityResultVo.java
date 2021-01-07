package com.wms.api.move;

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
 * 移动相关质检单据管理 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-22
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "MoveWarehouseQualityResultVo对象", description = "移动相关质检单据管理查询参数")
public class MoveWarehouseQualityResultVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表id")
    private Long id;

    @ApiModelProperty(value = "移动单号，入库单号，出库单号，或者移库单号")
    private String billCode;

    @ApiModelProperty(value = "移动子单号")
    private String subBillCode;

    @ApiModelProperty(value = "单据类型")
    private String billType;

    @ApiModelProperty(value = "台账ID")
    private String accountId;

    @ApiModelProperty(value = "物料编码")
    private String productionCode;

    @ApiModelProperty(value = "质量编码")
    private String qualityCode;

    @ApiModelProperty(value = "之前质量状态")
    private String beforeQualityStatus;

    @ApiModelProperty(value = "现在质量状态")
    private String qualityResult;

    @ApiModelProperty(value = "合格数量")
    private BigDecimal qualifiedQuantity;

    @ApiModelProperty(value = "不合格数量")
    private BigDecimal unqualifiedQuantity;

    @ApiModelProperty(value = "合格证号")
    private String certificateNo;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "备注")
    private String qualityDetails;

private Date qualityTime;

}
