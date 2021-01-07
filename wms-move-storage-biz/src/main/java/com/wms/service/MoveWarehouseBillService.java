package com.wms.service;

import com.wms.model.entity.MoveWarehouseBillEntity;
import com.xac.core.service.BaseService;
import com.wms.api.move.MoveWarehouseBillQueryParam;
import com.wms.model.bo.move.MoveWarehouseBillBo;
import com.xac.core.api.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 移库表 服务类
 * </pre>
 *
 * @author puck
 * @since 2020-12-22
 */
public interface MoveWarehouseBillService extends BaseService<MoveWarehouseBillEntity> {

    /**
     * 保存
     *
     * @param moveWarehouseBill
     * @return
     * @throws Exception
     */
    boolean saveMoveWarehouseBill(MoveWarehouseBillBo moveWarehouseBill);

    /**
     * 修改
     *
     * @param moveWarehouseBill
     * @return
     * @throws Exception
     */
    boolean updateMoveWarehouseBill(MoveWarehouseBillBo moveWarehouseBill);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteMoveWarehouseBill(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    MoveWarehouseBillBo getMoveWarehouseBillById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param moveWarehouseBillQueryParam
     * @return
     * @throws Exception
     */
    Paging<MoveWarehouseBillBo> getMoveWarehouseBillPageList(MoveWarehouseBillQueryParam moveWarehouseBillQueryParam);

}
