package com.wms.service.impl;

import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.MoveWarehouseQualityResultEntity;
import com.wms.mapper.move.MoveWarehouseQualityResultMapper;
import com.wms.service.MoveWarehouseQualityResultService;
import com.wms.api.move.MoveWarehouseQualityResultQueryParam;
import com.wms.model.bo.move.MoveWarehouseQualityResultBo;
import com.xac.core.service.impl.BaseServiceImpl;
import com.xac.core.api.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;


/**
 * <pre>
 * 移动相关质检单据管理 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2020-12-22
 */
@Slf4j
@Service
public class MoveWarehouseQualityResultServiceImpl extends BaseServiceImpl<MoveWarehouseQualityResultMapper, MoveWarehouseQualityResultEntity> implements MoveWarehouseQualityResultService {

    @Autowired
    private MoveWarehouseQualityResultMapper moveWarehouseQualityResultMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveMoveWarehouseQualityResult(MoveWarehouseQualityResultBo moveWarehouseQualityResult) {
        MoveWarehouseQualityResultEntity entity = new MoveWarehouseQualityResultEntity();
        BeanUtils.copyProperties(moveWarehouseQualityResult , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateMoveWarehouseQualityResult(MoveWarehouseQualityResultBo moveWarehouseQualityResult) {
        MoveWarehouseQualityResultEntity entity = new MoveWarehouseQualityResultEntity();
        BeanUtils.copyProperties(moveWarehouseQualityResult , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteMoveWarehouseQualityResult(Long id) {
        return super.removeById(id);
    }

    @Override
    public MoveWarehouseQualityResultBo getMoveWarehouseQualityResultById(Serializable id) {
        return moveWarehouseQualityResultMapper.getMoveWarehouseQualityResultById(id);
    }

    @Override
    public Paging<MoveWarehouseQualityResultBo> getMoveWarehouseQualityResultPageList(MoveWarehouseQualityResultQueryParam moveWarehouseQualityResultQueryParam) {
        Page page = setPageParam(moveWarehouseQualityResultQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<MoveWarehouseQualityResultBo> iPage = moveWarehouseQualityResultMapper.getMoveWarehouseQualityResultPageList(page, moveWarehouseQualityResultQueryParam);
        return new Paging(iPage);
    }

}
