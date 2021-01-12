package com.wms.model.bo.move;

import com.xac.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * 移库单子表 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2021-01-11
 */
@Data
@Accessors(chain = true)
public class MoveWarehouseBillSubBo extends BaseBo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    private Long id;

    /**
     * 移库单编号
     */
    private String billCode;

    /**
     * 移库前台账ID
     */
    private String accountId;

    /**
     * 要移入库房的编码
     */
    private String inWarehouseLocationCode;

    /**
     * 移库前项目编码
     */
    private String beforeProjectCode;

    /**
     * 移库后项目编码
     */
    private String endProjectCode;

    /**
     * 移库前价格
     */
    private BigDecimal beforePrice;

    /**
     * 移库后价格
     */
    private BigDecimal endPrice;

    /**
     * 移库前价格策略
     */
    private BigDecimal beforePriceCategory;

    /**
     * 移库后价格策略
     */
    private BigDecimal endPriceCategory;

    /**
     * 移动数量
     */
    private BigDecimal moveQuantity;

    /**
     * 移动质检消耗数量
     */
    private BigDecimal moveQualityConsumeQuantity;

    /**
     * 状态
     */
    private String status;

}
