package com.wms.model.bo.move;

import com.xac.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 移库表 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-22
 */
@Data
@Accessors(chain = true)
public class MoveWarehouseBillBo extends BaseBo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
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
