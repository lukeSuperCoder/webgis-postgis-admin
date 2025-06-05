package com.soil.controller;

import com.soil.common.Result;
import com.soil.entity.SoilPart;
import com.soil.service.SoilPartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 土壤分区控制器
 */
@RestController
@RequestMapping("/soil-part")
@Tag(name = "土壤分区管理", description = "土壤分区信息相关接口")
public class SoilPartController {

    @Resource
    private SoilPartService soilPartService;

    /**
     * 根据ID查询土壤分区信息
     */
    @GetMapping("/get/{id}")
    @Operation(summary = "根据ID查询", description = "根据土壤分区ID查询详细信息")
    public Result<SoilPart> get(@Parameter(description = "土壤分区ID") @PathVariable Integer id) {
        return Result.success(soilPartService.getById(id));
    }

    /**
     * 查询土壤分区列表
     */
    @GetMapping("/list")
    @Operation(summary = "查询列表", description = "查询土壤分区列表信息")
    public Result<List<SoilPart>> list() {
        return Result.success(soilPartService.list());
    }

    /**
     * 条件查询土壤分区信息
     */
    @GetMapping("/listByCondition")
    @Operation(summary = "条件查询", description = "根据条件查询土壤分区信息")
    public Result<List<SoilPart>> listByCondition(@Parameter(description = "查询条件") SoilPart soilPart) {
        return Result.success(soilPartService.listByCondition(soilPart));
    }
    
    /**
     * 根据行政区域查询土壤分区信息
     */
    @GetMapping("/listByRegion")
    @Operation(summary = "区域查询", description = "根据行政区域查询土壤分区信息")
    public Result<List<SoilPart>> listByRegion(
            @Parameter(description = "省份名称") @RequestParam(required = false) String province,
            @Parameter(description = "城市名称") @RequestParam(required = false) String city,
            @Parameter(description = "县区名称") @RequestParam(required = false) String county,
            @Parameter(description = "乡镇名称") @RequestParam(required = false) String town) {
        return Result.success(soilPartService.listByRegion(province, city, county, town));
    }
    
    /**
     * 根据空间范围查询土壤分区信息
     */
    @GetMapping("/listByGeometry")
    @Operation(summary = "空间范围查询", description = "根据WKT格式的几何范围查询土壤分区信息")
    public Result<List<SoilPart>> listByGeometry(@Parameter(description = "WKT格式的几何范围") @RequestParam String wkt) {
        return Result.success(soilPartService.listByGeometry(wkt));
    }
    
    /**
     * 查询酸化土壤信息
     */
    @GetMapping("/listAcidifiedSoil")
    @Operation(summary = "酸化土壤查询", description = "查询pH值低于指定值的酸化土壤")
    public Result<List<SoilPart>> listAcidifiedSoil(
            @Parameter(description = "pH阈值") @RequestParam Double phValue, 
            @Parameter(description = "年份(82、08、16)") @RequestParam(required = false, defaultValue = "16") String year) {
        return Result.success(soilPartService.listAcidifiedSoil(phValue, year));
    }
    
    /**
     * 查询土壤pH变化情况
     */
    @GetMapping("/listByPhChange")
    @Operation(summary = "pH变化查询", description = "查询不同时期pH值变化情况")
    public Result<List<SoilPart>> listByPhChange(
            @Parameter(description = "时间段(8208、0816、8216)") @RequestParam(required = false, defaultValue = "8216") String period, 
            @Parameter(description = "变化阈值") @RequestParam Double changeValue) {
        return Result.success(soilPartService.listByPhChange(period, changeValue));
    }
    
    /**
     * 查询有机质含量满足条件的土壤信息
     */
    @GetMapping("/listByOrganicMatter")
    @Operation(summary = "有机质含量查询", description = "查询有机质含量在指定范围内的土壤")
    public Result<List<SoilPart>> listByOrganicMatter(
            @Parameter(description = "最小值") @RequestParam Double minValue, 
            @Parameter(description = "最大值") @RequestParam Double maxValue) {
        return Result.success(soilPartService.listByOrganicMatter(minValue, maxValue));
    }
    
    /**
     * 统计不同土壤类型的面积
     */
    @GetMapping("/statisticsByType")
    @Operation(summary = "土壤类型面积统计", description = "统计不同土壤类型的面积")
    public Result<List<Map<String, Object>>> statisticsByType() {
        return Result.success(soilPartService.statisticsByType());
    }
    
    /**
     * 统计不同行政区域内土壤的平均pH值
     */
    @GetMapping("/statisticsPhByRegion")
    @Operation(summary = "区域pH值统计", description = "统计不同行政区域内土壤的平均pH值")
    public Result<List<Map<String, Object>>> statisticsPhByRegion(
            @Parameter(description = "行政级别(province/city/county/town)") @RequestParam(required = false, defaultValue = "county") String level,
            @Parameter(description = "年份(82、08、16)") @RequestParam(required = false, defaultValue = "16") String year) {
        return Result.success(soilPartService.statisticsPhByRegion(level, year));
    }
    
    /**
     * 统计指定区域内土壤属性均值
     */
    @GetMapping("/statisticsByGeometry")
    @Operation(summary = "区域内属性统计", description = "统计指定几何区域内土壤属性均值")
    public Result<Map<String, Object>> statisticsByGeometry(@Parameter(description = "WKT格式的几何范围") @RequestParam String wkt) {
        return Result.success(soilPartService.statisticsByGeometry(wkt));
    }
} 