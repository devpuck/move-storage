package com.wms.model.bo.move;

import com.xac.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * 移动相关质检单据管理 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-22
 */
@Data
@Accessors(chain = true)
public class MoveWarehouseQualityResultBo extends BaseBo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
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
