package com.wms.service;

import com.wms.model.entity.MoveWarehouseBillSubEntity;
import com.xac.core.service.BaseService;
import com.wms.api.move.MoveWarehouseBillSubQueryParam;
import com.wms.model.bo.move.MoveWarehouseBillSubBo;
import com.xac.core.api.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 移库单子表 服务类
 * </pre>
 *
 * @author puck
 * @since 2021-01-11
 */
public interface MoveWarehouseBillSubService extends BaseService<MoveWarehouseBillSubEntity> {

    /**
     * 保存
     *
     * @param moveWarehouseBillSub
     * @return
     * @throws Exception
     */
    boolean saveMoveWarehouseBillSub(MoveWarehouseBillSubBo moveWarehouseBillSub);

    /**
     * 修改
     *
     * @param moveWarehouseBillSub
     * @return
     * @throws Exception
     */
    boolean updateMoveWarehouseBillSub(MoveWarehouseBillSubBo moveWarehouseBillSub);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteMoveWarehouseBillSub(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    MoveWarehouseBillSubBo getMoveWarehouseBillSubById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param moveWarehouseBillSubQueryParam
     * @return
     * @throws Exception
     */
    Paging<MoveWarehouseBillSubBo> getMoveWarehouseBillSubPageList(MoveWarehouseBillSubQueryParam moveWarehouseBillSubQueryParam);

}
