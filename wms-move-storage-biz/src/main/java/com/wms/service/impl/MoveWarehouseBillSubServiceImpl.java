package com.wms.service.impl;

import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.MoveWarehouseBillSubEntity;
import com.wms.mapper.move.MoveWarehouseBillSubMapper;
import com.wms.service.MoveWarehouseBillSubService;
import com.wms.api.move.MoveWarehouseBillSubQueryParam;
import com.wms.model.bo.move.MoveWarehouseBillSubBo;
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
 * 移库单子表 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2021-01-11
 */
@Slf4j
@Service
public class MoveWarehouseBillSubServiceImpl extends BaseServiceImpl<MoveWarehouseBillSubMapper, MoveWarehouseBillSubEntity> implements MoveWarehouseBillSubService {

    @Autowired
    private MoveWarehouseBillSubMapper moveWarehouseBillSubMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveMoveWarehouseBillSub(MoveWarehouseBillSubBo moveWarehouseBillSub) {
        MoveWarehouseBillSubEntity entity = new MoveWarehouseBillSubEntity();
        BeanUtils.copyProperties(moveWarehouseBillSub , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateMoveWarehouseBillSub(MoveWarehouseBillSubBo moveWarehouseBillSub) {
        MoveWarehouseBillSubEntity entity = new MoveWarehouseBillSubEntity();
        BeanUtils.copyProperties(moveWarehouseBillSub , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteMoveWarehouseBillSub(Long id) {
        return super.removeById(id);
    }

    @Override
    public MoveWarehouseBillSubBo getMoveWarehouseBillSubById(Serializable id) {
        return moveWarehouseBillSubMapper.getMoveWarehouseBillSubById(id);
    }

    @Override
    public Paging<MoveWarehouseBillSubBo> getMoveWarehouseBillSubPageList(MoveWarehouseBillSubQueryParam moveWarehouseBillSubQueryParam) {
        Page page = setPageParam(moveWarehouseBillSubQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<MoveWarehouseBillSubBo> iPage = moveWarehouseBillSubMapper.getMoveWarehouseBillSubPageList(page, moveWarehouseBillSubQueryParam);
        return new Paging(iPage);
    }

}
