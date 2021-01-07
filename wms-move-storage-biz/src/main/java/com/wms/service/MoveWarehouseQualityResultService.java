package com.wms.service;

import com.wms.model.entity.MoveWarehouseQualityResultEntity;
import com.xac.core.service.BaseService;
import com.wms.api.move.MoveWarehouseQualityResultQueryParam;
import com.wms.model.bo.move.MoveWarehouseQualityResultBo;
import com.xac.core.api.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 移动相关质检单据管理 服务类
 * </pre>
 *
 * @author puck
 * @since 2020-12-22
 */
public interface MoveWarehouseQualityResultService extends BaseService<MoveWarehouseQualityResultEntity> {

    /**
     * 保存
     *
     * @param moveWarehouseQualityResult
     * @return
     * @throws Exception
     */
    boolean saveMoveWarehouseQualityResult(MoveWarehouseQualityResultBo moveWarehouseQualityResult);

    /**
     * 修改
     *
     * @param moveWarehouseQualityResult
     * @return
     * @throws Exception
     */
    boolean updateMoveWarehouseQualityResult(MoveWarehouseQualityResultBo moveWarehouseQualityResult);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteMoveWarehouseQualityResult(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    MoveWarehouseQualityResultBo getMoveWarehouseQualityResultById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param moveWarehouseQualityResultQueryParam
     * @return
     * @throws Exception
     */
    Paging<MoveWarehouseQualityResultBo> getMoveWarehouseQualityResultPageList(MoveWarehouseQualityResultQueryParam moveWarehouseQualityResultQueryParam);

}
