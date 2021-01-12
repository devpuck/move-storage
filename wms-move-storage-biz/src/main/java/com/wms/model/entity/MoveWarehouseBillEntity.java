package com.wms.model.entity;

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
 * 移库表
 * </pre>
 *
 * @author puck
 * @since 2021-01-11
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("WMS_MOVE_WAREHOUSE_BILL")
public class MoveWarehouseBillEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 移出库房编码
     */
    private String moveOutWarehouseCode;

    /**
     * 移出库房编码
     */
    private String moveInWarehouseCode;

    /**
     * 移库单号
     */
    private String billCode;

    /**
     * 事务编码
     */
    private String workCode;

    /**
     * 出库单号，自动创建
     */
    private String moveOutBillCode;

    /**
     * 入库单号，自动创建
     */
    private String moveInBillCode;

    /**
     * 状态
     */
    private String status;

    /**
     * 是否需要质检
     */
    private String needQuality;

    /**
     * 质检后处理状态，主要是不合格如何处理，如退回原库，还是转移到原库
     */
    private String qualityCategory;

    private String version;

    private String note;

}
