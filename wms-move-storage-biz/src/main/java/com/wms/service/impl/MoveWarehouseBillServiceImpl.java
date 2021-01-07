package com.wms.service.impl;

import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.MoveWarehouseBillEntity;
import com.wms.mapper.move.MoveWarehouseBillMapper;
import com.wms.service.MoveWarehouseBillService;
import com.wms.api.move.MoveWarehouseBillQueryParam;
import com.wms.model.bo.move.MoveWarehouseBillBo;
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
 * 移库表 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2020-12-22
 */
@Slf4j
@Service
public class MoveWarehouseBillServiceImpl extends BaseServiceImpl<MoveWarehouseBillMapper, MoveWarehouseBillEntity> implements MoveWarehouseBillService {

    @Autowired
    private MoveWarehouseBillMapper moveWarehouseBillMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveMoveWarehouseBill(MoveWarehouseBillBo moveWarehouseBill) {
        MoveWarehouseBillEntity entity = new MoveWarehouseBillEntity();
        BeanUtils.copyProperties(moveWarehouseBill , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateMoveWarehouseBill(MoveWarehouseBillBo moveWarehouseBill) {
        MoveWarehouseBillEntity entity = new MoveWarehouseBillEntity();
        BeanUtils.copyProperties(moveWarehouseBill , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteMoveWarehouseBill(Long id) {
        return super.removeById(id);
    }

    @Override
    public MoveWarehouseBillBo getMoveWarehouseBillById(Serializable id) {
        return moveWarehouseBillMapper.getMoveWarehouseBillById(id);
    }

    @Override
    public Paging<MoveWarehouseBillBo> getMoveWarehouseBillPageList(MoveWarehouseBillQueryParam moveWarehouseBillQueryParam) {
        Page page = setPageParam(moveWarehouseBillQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<MoveWarehouseBillBo> iPage = moveWarehouseBillMapper.getMoveWarehouseBillPageList(page, moveWarehouseBillQueryParam);
        return new Paging(iPage);
    }

}
