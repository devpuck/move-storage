package com.wms.service.impl;

import com.wms.api.account.AccountVo;
import com.wms.api.instorage.InWarehouseBillSubVo;
import com.wms.api.instorage.InWarehouseBillVo;
import com.wms.model.bo.move.MoveWarehouseBillSubBo;
import com.wms.model.entity.MoveWarehouseBillSubEntity;
import com.wms.sdk.account.QueryAccountManager;
import com.wms.service.MoveWarehouseBillSubService;
import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.MoveWarehouseBillEntity;
import com.wms.mapper.move.MoveWarehouseBillMapper;
import com.wms.service.MoveWarehouseBillService;
import com.wms.api.move.MoveWarehouseBillQueryParam;
import com.wms.model.bo.move.MoveWarehouseBillBo;
import com.xac.core.service.impl.BaseServiceImpl;
import com.xac.core.api.Paging;
import com.xac.core.util.BeanListUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanInfoFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


/**
 * <pre>
 * 移库表 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2021-01-11
 */
@Slf4j
@Service
public class MoveWarehouseBillServiceImpl extends BaseServiceImpl<MoveWarehouseBillMapper, MoveWarehouseBillEntity> implements MoveWarehouseBillService
{

    @Autowired
    private MoveWarehouseBillMapper moveWarehouseBillMapper;

    @Autowired
    private MoveWarehouseBillSubService moveWarehouseBillSubService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveMoveWarehouseBill(MoveWarehouseBillBo moveWarehouseBill) throws Exception
    {
        boolean result = false;

        List<MoveWarehouseBillSubBo> moveWarehouseBillSubBoList = moveWarehouseBill.getMoveWarehouseBillSubBoList();
        if(null != moveWarehouseBillSubBoList)
        {

        }

        MoveWarehouseBillEntity entity = new MoveWarehouseBillEntity();
        BeanUtils.copyProperties(moveWarehouseBill, entity);
        result = super.save(entity);
        if (!result)
        {
            return result;
        }

        List<MoveWarehouseBillSubEntity> moveWarehouseBillEntityList = BeanListUtil.copyListProperties(moveWarehouseBillSubBoList, MoveWarehouseBillSubEntity.class);
        result = moveWarehouseBillSubService.saveBatch(moveWarehouseBillEntityList);

        return result;
    }

    public List<AccountVo> queryAccountList(MoveWarehouseBillBo moveWarehouseBill)
    {
        QueryAccountManager queryAccountManager = new QueryAccountManager();
        List<AccountVo> accountVoList = new ArrayList<AccountVo>();
        List<MoveWarehouseBillSubBo> moveWarehouseBillSubBoList = moveWarehouseBill.getMoveWarehouseBillSubBoList();
        if (null != moveWarehouseBillSubBoList)
        {
            List<InWarehouseBillSubVo> inWarehouseBillSubVoList = new ArrayList<InWarehouseBillSubVo>();
            Iterator<MoveWarehouseBillSubBo> it = moveWarehouseBillSubBoList.iterator();
            while (it.hasNext())
            {
                MoveWarehouseBillSubBo moveWarehouseBillSubBo = it.next();
                AccountVo accountVo = queryAccountManager.queryAccountById(moveWarehouseBillSubBo.getAccountId());
                if (null != accountVo)
                {
                    accountVoList.add(accountVo);
                }
            }

        }
        return accountVoList;
    }

    public boolean createInBill(MoveWarehouseBillBo moveWarehouseBill)
    {

        boolean result = false;
        InWarehouseBillVo inWarehouseBillVo = new InWarehouseBillVo();
        inWarehouseBillVo.setWarehouseCode(moveWarehouseBill.getMoveInWarehouseCode());
        //后期加上验证判断
        inWarehouseBillVo.setWorkCode((moveWarehouseBill.getWorkCode() + "_1"));
        inWarehouseBillVo.setDealCode((moveWarehouseBill.getWorkCode() + "_1"));
        String inBillCode = UUID.randomUUID().toString().replaceAll("-", "");
        moveWarehouseBill.setMoveInBillCode(inBillCode);
        inWarehouseBillVo.setBillCode(inBillCode);


        return result;
    }

    public boolean createOutBill(MoveWarehouseBillBo moveWarehouseBill)
    {
        boolean result = false;
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateMoveWarehouseBill(MoveWarehouseBillBo moveWarehouseBill)
    {
        MoveWarehouseBillEntity entity = new MoveWarehouseBillEntity();
        BeanUtils.copyProperties(moveWarehouseBill, entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteMoveWarehouseBill(Long id)
    {
        return super.removeById(id);
    }

    @Override
    public MoveWarehouseBillBo getMoveWarehouseBillById(Serializable id)
    {
        return moveWarehouseBillMapper.getMoveWarehouseBillById(id);
    }

    @Override
    public Paging<MoveWarehouseBillBo> getMoveWarehouseBillPageList(MoveWarehouseBillQueryParam moveWarehouseBillQueryParam)
    {
        Page page = setPageParam(moveWarehouseBillQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<MoveWarehouseBillBo> iPage = moveWarehouseBillMapper.getMoveWarehouseBillPageList(page, moveWarehouseBillQueryParam);
        return new Paging(iPage);
    }

}
