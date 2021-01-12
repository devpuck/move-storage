package com.wms.mapper.move;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.MoveWarehouseBillEntity;
import com.wms.api.move.MoveWarehouseBillQueryParam;
import com.wms.model.bo.move.MoveWarehouseBillBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 移库表 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2021-01-11
 */
@Repository
public interface MoveWarehouseBillMapper extends BaseMapper<MoveWarehouseBillEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    MoveWarehouseBillBo getMoveWarehouseBillById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param moveWarehouseBillQueryParam
     * @return
     */
    IPage<MoveWarehouseBillBo> getMoveWarehouseBillPageList(@Param("page") Page page, @Param("param") MoveWarehouseBillQueryParam moveWarehouseBillQueryParam);

}
