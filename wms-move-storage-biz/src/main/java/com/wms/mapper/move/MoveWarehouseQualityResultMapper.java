package com.wms.mapper.move;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.MoveWarehouseQualityResultEntity;
import com.wms.api.move.MoveWarehouseQualityResultQueryParam;
import com.wms.model.bo.move.MoveWarehouseQualityResultBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 移动相关质检单据管理 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2020-12-22
 */
@Repository
public interface MoveWarehouseQualityResultMapper extends BaseMapper<MoveWarehouseQualityResultEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    MoveWarehouseQualityResultBo getMoveWarehouseQualityResultById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param moveWarehouseQualityResultQueryParam
     * @return
     */
    IPage<MoveWarehouseQualityResultBo> getMoveWarehouseQualityResultPageList(@Param("page") Page page, @Param("param") MoveWarehouseQualityResultQueryParam moveWarehouseQualityResultQueryParam);

}
