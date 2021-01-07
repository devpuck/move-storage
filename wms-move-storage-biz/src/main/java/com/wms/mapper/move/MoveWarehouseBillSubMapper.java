package com.wms.mapper.move;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.MoveWarehouseBillSubEntity;
import com.wms.api.move.MoveWarehouseBillSubQueryParam;
import com.wms.model.bo.move.MoveWarehouseBillSubBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 移库单子表 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2020-12-24
 */
@Repository
public interface MoveWarehouseBillSubMapper extends BaseMapper<MoveWarehouseBillSubEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    MoveWarehouseBillSubBo getMoveWarehouseBillSubById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param moveWarehouseBillSubQueryParam
     * @return
     */
    IPage<MoveWarehouseBillSubBo> getMoveWarehouseBillSubPageList(@Param("page") Page page, @Param("param") MoveWarehouseBillSubQueryParam moveWarehouseBillSubQueryParam);

}
