package com.wms.model.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.xac.core.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 移库单子表
 * </pre>
 *
 * @author puck
 * @since 2021-01-11
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("WMS_MOVE_WAREHOUSE_BILL_SUB")
public class MoveWarehouseBillSubEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    @TableId(value = "ID", type = IdType.AUTO)
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
