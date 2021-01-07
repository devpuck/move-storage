package com.wms.model.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * 移动相关质检单据管理
 * </pre>
 *
 * @author puck
 * @since 2020-12-22
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("WMS_MOVE_WAREHOUSE_QUALITY_RESULT")
public class MoveWarehouseQualityResultEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 移动单号，入库单号，出库单号，或者移库单号
     */
    private String billCode;

    /**
     * 移动子单号
     */
    private String subBillCode;

    /**
     * 单据类型
     */
    private String billType;

    /**
     * 台账ID
     */
    private String accountId;

    /**
     * 物料编码
     */
    private String productionCode;

    /**
     * 质量编码
     */
    private String qualityCode;

    /**
     * 之前质量状态
     */
    private String beforeQualityStatus;

    /**
     * 现在质量状态
     */
    private String qualityResult;

    /**
     * 合格数量
     */
    private BigDecimal qualifiedQuantity;

    /**
     * 不合格数量
     */
    private BigDecimal unqualifiedQuantity;

    /**
     * 合格证号
     */
    private String certificateNo;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String qualityDetails;

    private Date qualityTime;

}
