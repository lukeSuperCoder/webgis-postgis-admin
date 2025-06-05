package com.soil.controller;

import com.soil.common.Result;
import com.soil.entity.SoilInfo;
import com.soil.service.SoilInfoService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 土壤信息控制器
 */
@RestController
@RequestMapping("/soil")
public class SoilInfoController {

    @Resource
    private SoilInfoService soilInfoService;

    /**
     * 添加土壤信息
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SoilInfo soilInfo) {
        return Result.success(soilInfoService.add(soilInfo));
    }

    /**
     * 更新土壤信息
     */
    @PutMapping("/update")
    public Result<Boolean> update(@RequestBody SoilInfo soilInfo) {
        return Result.success(soilInfoService.update(soilInfo));
    }

    /**
     * 删除土壤信息
     */
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(soilInfoService.delete(id));
    }

    /**
     * 根据ID查询土壤信息
     */
    @GetMapping("/get/{id}")
    public Result<SoilInfo> get(@PathVariable Long id) {
        return Result.success(soilInfoService.getById(id));
    }

    /**
     * 查询所有土壤信息
     */
    @GetMapping("/list")
    public Result<List<SoilInfo>> list() {
        return Result.success(soilInfoService.list());
    }
    
    /**
     * 根据条件查询土壤信息列表
     */
    @GetMapping("/listByCondition")
    public Result<List<SoilInfo>> listByCondition(SoilInfo soilInfo) {
        return Result.success(soilInfoService.listByCondition(soilInfo));
    }
    
    /**
     * 根据空间范围查询土壤信息
     */
    @GetMapping("/listByGeometry")
    public Result<List<SoilInfo>> listByGeometry(@RequestParam String wkt) {
        return Result.success(soilInfoService.listByGeometry(wkt));
    }
    
    /**
     * 查询酸化土壤信息
     */
    @GetMapping("/listAcidifiedSoil")
    public Result<List<SoilInfo>> listAcidifiedSoil(@RequestParam Double phValue, @RequestParam(required = false) String wkt) {
        return Result.success(soilInfoService.listAcidifiedSoil(phValue, wkt));
    }
    
    /**
     * 统计指定区域内土壤信息
     */
    @GetMapping("/statistics")
    public Result<Map<String, Object>> statistics(@RequestParam String wkt) {
        return Result.success(soilInfoService.statisticsByGeometry(wkt));
    }
} 