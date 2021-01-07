package com.wms.controller;

import com.xac.core.util.BeanListUtil;
import com.wms.model.entity.MoveWarehouseQualityResultEntity;
import com.wms.service.MoveWarehouseQualityResultService;
import com.wms.api.move.MoveWarehouseQualityResultQueryParam;
import com.wms.api.move.MoveWarehouseQualityResultVo;
import com.wms.model.bo.move.MoveWarehouseQualityResultBo;
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
 * 移动相关质检单据管理 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2020-12-22
 */
@Slf4j
@RestController
@RequestMapping("/move")
@Api("移动相关质检单据管理 API")
public class MoveWarehouseQualityResultController extends BaseController {

    @Autowired
    private MoveWarehouseQualityResultService moveWarehouseQualityResultService;

    /**
     * 添加移动相关质检单据管理
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加MoveWarehouseQualityResult对象", notes = "添加移动相关质检单据管理", response = ApiResult.class)
    public ApiResult<Boolean> addMoveWarehouseQualityResult(@Valid @RequestBody MoveWarehouseQualityResultVo moveWarehouseQualityResult) throws Exception {
         MoveWarehouseQualityResultBo bo = new MoveWarehouseQualityResultBo();
        BeanUtils.copyProperties(moveWarehouseQualityResult,bo);

        boolean flag = moveWarehouseQualityResultService.saveMoveWarehouseQualityResult(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改移动相关质检单据管理
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改MoveWarehouseQualityResult对象", notes = "修改移动相关质检单据管理", response = ApiResult.class)
    public ApiResult<Boolean> updateMoveWarehouseQualityResult(@Valid @RequestBody MoveWarehouseQualityResultVo moveWarehouseQualityResult) throws Exception {
        MoveWarehouseQualityResultBo bo = new MoveWarehouseQualityResultBo();
        BeanUtils.copyProperties(moveWarehouseQualityResult,bo);

        boolean flag = moveWarehouseQualityResultService.updateMoveWarehouseQualityResult(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除移动相关质检单据管理
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除MoveWarehouseQualityResult对象", notes = "删除移动相关质检单据管理", response = ApiResult.class)
    public ApiResult<Boolean> deleteMoveWarehouseQualityResult(@PathVariable("id") Long id) throws Exception {
        boolean flag = moveWarehouseQualityResultService.deleteMoveWarehouseQualityResult(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取移动相关质检单据管理
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取MoveWarehouseQualityResult对象详情", notes = "查看移动相关质检单据管理", response = MoveWarehouseQualityResultVo.class)
    public ApiResult<MoveWarehouseQualityResultVo> getMoveWarehouseQualityResult(@PathVariable("id") Long id) throws Exception {
        MoveWarehouseQualityResultBo moveWarehouseQualityResultBo = moveWarehouseQualityResultService.getMoveWarehouseQualityResultById(id);
        MoveWarehouseQualityResultVo queryVo = null;
        if (moveWarehouseQualityResultBo != null) {
            queryVo = new MoveWarehouseQualityResultVo();
            BeanUtils.copyProperties(moveWarehouseQualityResultBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 移动相关质检单据管理分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取MoveWarehouseQualityResult分页列表", notes = "移动相关质检单据管理分页列表", response = MoveWarehouseQualityResultVo.class)
    public ApiResult<Paging<MoveWarehouseQualityResultVo>> getMoveWarehouseQualityResultPageList(@Valid @RequestBody MoveWarehouseQualityResultQueryParam moveWarehouseQualityResultQueryParam) throws Exception {
        Paging<MoveWarehouseQualityResultBo> paging = moveWarehouseQualityResultService.getMoveWarehouseQualityResultPageList(moveWarehouseQualityResultQueryParam);
        Paging<MoveWarehouseQualityResultVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), MoveWarehouseQualityResultVo.class));
        return ApiResult.ok(resultPage);
    }

}

