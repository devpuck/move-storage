package com.wms.controller;

import com.wms.api.move.MoveWarehouseBillSubVo;
import com.wms.errorcode.ErrorCode;
import com.wms.model.bo.move.MoveWarehouseBillSubBo;
import com.wms.util.CheckParameter;
import com.xac.core.api.ApiResultCode;
import com.xac.core.util.BeanListUtil;
import com.wms.model.entity.MoveWarehouseBillEntity;
import com.wms.service.MoveWarehouseBillService;
import com.wms.api.move.MoveWarehouseBillQueryParam;
import com.wms.api.move.MoveWarehouseBillVo;
import com.wms.model.bo.move.MoveWarehouseBillBo;
import com.xac.core.api.ApiResult;
import com.xac.core.api.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;


import javax.validation.Valid;

import com.xac.core.api.Paging;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <pre>
 * 移库表 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2021-01-11
 */
@Slf4j
@RestController
@RequestMapping("/move")
@Api("移库表 API")
public class MoveWarehouseBillController extends BaseController
{

    @Autowired
    private MoveWarehouseBillService moveWarehouseBillService;

    /**
     * 添加移库表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加MoveWarehouseBill对象", notes = "添加移库表", response = ApiResult.class)
    public ApiResult<Boolean> addMoveWarehouseBill(@Valid @RequestBody MoveWarehouseBillVo moveWarehouseBill) throws Exception
    {

        if(!checkAddWarehouseBillParam(moveWarehouseBill))
        {
            return ApiResult.result(ApiResultCode.PARAMETER_EXCEPTION);
        }

        MoveWarehouseBillBo bo = new MoveWarehouseBillBo();
        BeanUtils.copyProperties(moveWarehouseBill, bo);

        List<MoveWarehouseBillSubVo> moveWarehouseBillSubVoList = moveWarehouseBill.getMoveWarehouseBillSubVoList();
        if(null != moveWarehouseBillSubVoList)
        {
            List<MoveWarehouseBillSubBo> moveWarehouseBillSubBoList = new ArrayList<MoveWarehouseBillSubBo>();
            copyMoveBillSub(moveWarehouseBillSubVoList,moveWarehouseBillSubBoList);
            bo.setMoveWarehouseBillSubBoList(moveWarehouseBillSubBoList);
        }

        boolean flag = moveWarehouseBillService.saveMoveWarehouseBill(bo);
        return ApiResult.result(flag);
    }


    public boolean checkAddWarehouseBillParam(MoveWarehouseBillVo moveWarehouseBill)
    {
        String inWarehouseCode = moveWarehouseBill.getMoveInWarehouseCode();
        String outWarehouseCode = moveWarehouseBill.getMoveOutWarehouseCode();
        if(ErrorCode.OK != CheckParameter.checkParameter(inWarehouseCode,outWarehouseCode))
        {
            return false;
        }

        List<MoveWarehouseBillSubVo> moveWarehouseBillSubVoList = moveWarehouseBill.getMoveWarehouseBillSubVoList();
        if(null != moveWarehouseBillSubVoList)
        {
            Iterator<MoveWarehouseBillSubVo> it = moveWarehouseBillSubVoList.iterator();
            while(it.hasNext())
            {
                MoveWarehouseBillSubVo moveWarehouseBillSubVo = it.next();
                if(null == moveWarehouseBillSubVo.getAccountVo() || null == moveWarehouseBillSubVo.getAccountVo().getId())
                {
                    return false;
                }
            }
        }
        return true;
    }

    public void copyMoveBillSub(List<MoveWarehouseBillSubVo> moveWarehouseBillSubVoList,List<MoveWarehouseBillSubBo> moveWarehouseBillSubBoList)
    {
        if(null == moveWarehouseBillSubVoList)
        {
            return;
        }

        Iterator<MoveWarehouseBillSubVo> it = moveWarehouseBillSubVoList.iterator();
        while(it.hasNext())
        {
            MoveWarehouseBillSubVo moveWarehouseBillSubVo = it.next();
            MoveWarehouseBillSubBo moveWarehouseBillSubBo = new MoveWarehouseBillSubBo();
            BeanUtils.copyProperties(moveWarehouseBillSubVo,moveWarehouseBillSubBo);

            String accountID = moveWarehouseBillSubVo.getAccountVo().getId().toString();
            moveWarehouseBillSubBo.setAccountId(accountID);
            moveWarehouseBillSubBoList.add(moveWarehouseBillSubBo);
        }
    }

    /**
     * 修改移库表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改MoveWarehouseBill对象", notes = "修改移库表", response = ApiResult.class)
    public ApiResult<Boolean> updateMoveWarehouseBill(@Valid @RequestBody MoveWarehouseBillVo moveWarehouseBill) throws Exception
    {
        MoveWarehouseBillBo bo = new MoveWarehouseBillBo();
        BeanUtils.copyProperties(moveWarehouseBill, bo);

        boolean flag = moveWarehouseBillService.updateMoveWarehouseBill(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除移库表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除MoveWarehouseBill对象", notes = "删除移库表", response = ApiResult.class)
    public ApiResult<Boolean> deleteMoveWarehouseBill(@PathVariable("id") Long id) throws Exception
    {
        boolean flag = moveWarehouseBillService.deleteMoveWarehouseBill(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取移库表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取MoveWarehouseBill对象详情", notes = "查看移库表", response = MoveWarehouseBillVo.class)
    public ApiResult<MoveWarehouseBillVo> getMoveWarehouseBill(@PathVariable("id") Long id) throws Exception
    {
        MoveWarehouseBillBo moveWarehouseBillBo = moveWarehouseBillService.getMoveWarehouseBillById(id);
        MoveWarehouseBillVo queryVo = null;
        if (moveWarehouseBillBo != null)
        {
            queryVo = new MoveWarehouseBillVo();
            BeanUtils.copyProperties(moveWarehouseBillBo, queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 移库表分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取MoveWarehouseBill分页列表", notes = "移库表分页列表", response = MoveWarehouseBillVo.class)
    public ApiResult<Paging<MoveWarehouseBillVo>> getMoveWarehouseBillPageList(@Valid @RequestBody MoveWarehouseBillQueryParam moveWarehouseBillQueryParam) throws Exception
    {
        Paging<MoveWarehouseBillBo> paging = moveWarehouseBillService.getMoveWarehouseBillPageList(moveWarehouseBillQueryParam);
        Paging<MoveWarehouseBillVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), MoveWarehouseBillVo.class));
        return ApiResult.ok(resultPage);
    }

}

