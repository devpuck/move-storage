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
 * 移库单子表
 * </pre>
 *
 * @author puck
 * @since 2020-12-24
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
     * 移库单号
     */
    private String billCode;

    /**
     * 移库前台账ID
     */
    private String accountId;

    /**
     * 物料编码
     */
    private String productionCode;

    /**
     * 是否为父件，0父件、1子件、2非父子件关系
     */
    private String isParent;

    /**
     * 物料制造处理状态，produce 在制品，clout 余料，waste废料
     */
    private String produceStatus;

    /**
     * 父产品编码
     */
    private String parentProductionCode;

    /**
     * 项目编码，批次属性
     */
    private String projectCode;

    /**
     * 牌号，本为物料属性，但是部分为1：n关系，目前无后期逻辑处理，仅仅记录
     */
    private String brand;

    /**
     * 规格，本为物料属性，但是部分为1：n关系，目前无后期逻辑处理，仅仅记录
     */
    private String specifications;

    /**
     * 状态/级别/型号，本为物料属性，但是部分为1：n关系，目前无后期逻辑处理，仅仅记录
     */
    private String productionLevel;

    /**
     * 技术条件
     */
    private String technicalConditions;

    /**
     * 附加技术条件，本为物料属性，但是部分为1：n关系，目前无后期逻辑处理，仅仅记录
     */
    private String additionalTechnicalConditions;

    /**
     * 三期代码，批次属性
     */
    private String threePeriodCode;

    /**
     * 生产日期，批次属性
     */
    private Date manufactureDate;

    /**
     * 过期日期，批次属性
     */
    private Date expirationDate;

    /**
     * 批次号，批次属性
     */
    private String batch;

    /**
     * 炉批号或小号，批次属性
     */
    private String splysotCode;

    /**
     * 机型，批次属性
     */
    private String aircraftCode;

    /**
     * 架次，批次属性
     */
    private String sortieCode;

    /**
     * 版号，批次属性
     */
    private String modelCode;

    /**
     * 构型号，批次属性
     */
    private String constructionCode;

    /**
     * 质量编号，批次属性
     */
    private String qualityCode;

    /**
     * 质检状态，批次属性
     */
    private String qualityStatus;

    /**
     * 状态，批次属性
     */
    private String status;

    /**
     * 合格证号，批次属性
     */
    private String certificateNo;

    /**
     * 供方合格证号
     */
    private String supplyCertificateNo;

    /**
     * 定价策略
     */
    private String priceCategory;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 价格单位
     */
    private String priceUnit;

    /**
     * 是否寄售
     */
    private String isConsignment;

    /**
     * 物料尺寸，本身为物料属性，此处尺寸仅仅在物料状态为余料时有效
     */
    private String productionSize;

    /**
     * 移动数量
     */
    private BigDecimal moveQuantity;

    /**
     * 移动质检消耗数量
     */
    private BigDecimal moveQualityConsumeQuantity;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    private String attribute6;

    private String attribute7;

    private String attribute8;

    private String attribute9;

    private String attribute10;

    private String version;

    /**
     * 备注
     */
    private String note;

}
