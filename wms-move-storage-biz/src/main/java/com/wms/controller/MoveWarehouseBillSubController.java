package com.wms.controller;

import com.xac.core.util.BeanListUtil;
import com.wms.model.entity.MoveWarehouseBillSubEntity;
import com.wms.service.MoveWarehouseBillSubService;
import com.wms.api.move.MoveWarehouseBillSubQueryParam;
import com.wms.api.move.MoveWarehouseBillSubVo;
import com.wms.model.bo.move.MoveWarehouseBillSubBo;
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

/**
 * <pre>
 * 移库单子表 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2021-01-11
 */
@Slf4j
@RestController
@RequestMapping("/move")
@Api("移库单子表 API")
public class MoveWarehouseBillSubController extends BaseController {

    @Autowired
    private MoveWarehouseBillSubService moveWarehouseBillSubService;

    /**
     * 添加移库单子表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加MoveWarehouseBillSub对象", notes = "添加移库单子表", response = ApiResult.class)
    public ApiResult<Boolean> addMoveWarehouseBillSub(@Valid @RequestBody MoveWarehouseBillSubVo moveWarehouseBillSub) throws Exception {
         MoveWarehouseBillSubBo bo = new MoveWarehouseBillSubBo();
        BeanUtils.copyProperties(moveWarehouseBillSub,bo);

        boolean flag = moveWarehouseBillSubService.saveMoveWarehouseBillSub(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改移库单子表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改MoveWarehouseBillSub对象", notes = "修改移库单子表", response = ApiResult.class)
    public ApiResult<Boolean> updateMoveWarehouseBillSub(@Valid @RequestBody MoveWarehouseBillSubVo moveWarehouseBillSub) throws Exception {
        MoveWarehouseBillSubBo bo = new MoveWarehouseBillSubBo();
        BeanUtils.copyProperties(moveWarehouseBillSub,bo);

        boolean flag = moveWarehouseBillSubService.updateMoveWarehouseBillSub(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除移库单子表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除MoveWarehouseBillSub对象", notes = "删除移库单子表", response = ApiResult.class)
    public ApiResult<Boolean> deleteMoveWarehouseBillSub(@PathVariable("id") Long id) throws Exception {
        boolean flag = moveWarehouseBillSubService.deleteMoveWarehouseBillSub(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取移库单子表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取MoveWarehouseBillSub对象详情", notes = "查看移库单子表", response = MoveWarehouseBillSubVo.class)
    public ApiResult<MoveWarehouseBillSubVo> getMoveWarehouseBillSub(@PathVariable("id") Long id) throws Exception {
        MoveWarehouseBillSubBo moveWarehouseBillSubBo = moveWarehouseBillSubService.getMoveWarehouseBillSubById(id);
        MoveWarehouseBillSubVo queryVo = null;
        if (moveWarehouseBillSubBo != null) {
            queryVo = new MoveWarehouseBillSubVo();
            BeanUtils.copyProperties(moveWarehouseBillSubBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 移库单子表分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取MoveWarehouseBillSub分页列表", notes = "移库单子表分页列表", response = MoveWarehouseBillSubVo.class)
    public ApiResult<Paging<MoveWarehouseBillSubVo>> getMoveWarehouseBillSubPageList(@Valid @RequestBody MoveWarehouseBillSubQueryParam moveWarehouseBillSubQueryParam) throws Exception {
        Paging<MoveWarehouseBillSubBo> paging = moveWarehouseBillSubService.getMoveWarehouseBillSubPageList(moveWarehouseBillSubQueryParam);
        Paging<MoveWarehouseBillSubVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), MoveWarehouseBillSubVo.class));
        return ApiResult.ok(resultPage);
    }

}

