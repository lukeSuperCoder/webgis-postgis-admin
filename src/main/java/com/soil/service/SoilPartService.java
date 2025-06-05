package com.soil.service;

import com.soil.entity.SoilPart;
import java.util.List;
import java.util.Map;

/**
 * 土壤分区服务接口
 */
public interface SoilPartService {

    /**
     * 根据ID查询土壤分区信息
     */
    SoilPart getById(Integer id);

    /**
     * 查询土壤分区列表
     */
    List<SoilPart> list();

    /**
     * 条件查询土壤分区信息
     */
    List<SoilPart> listByCondition(SoilPart soilPart);
    
    /**
     * 根据行政区域查询土壤分区信息
     */
    List<SoilPart> listByRegion(String province, String city, String county, String town);
    
    /**
     * 根据空间范围查询土壤分区信息
     * @param wkt WKT格式的几何对象字符串
     * @return 土壤分区信息列表
     */
    List<SoilPart> listByGeometry(String wkt);
    
    /**
     * 查询酸化土壤信息
     * @param phValue pH阈值
     * @param year 年份（82、08、16）
     * @return 土壤分区信息列表
     */
    List<SoilPart> listAcidifiedSoil(Double phValue, String year);
    
    /**
     * 查询土壤pH变化情况
     * @param period 时间段（8208、0816、8216）
     * @param changeValue 变化阈值
     * @return 土壤分区信息列表
     */
    List<SoilPart> listByPhChange(String period, Double changeValue);
    
    /**
     * 查询有机质含量满足条件的土壤信息
     * @param minValue 最小值
     * @param maxValue 最大值
     * @return 土壤分区信息列表
     */
    List<SoilPart> listByOrganicMatter(Double minValue, Double maxValue);
    
    /**
     * 统计不同土壤类型的面积
     * @return 统计结果
     */
    List<Map<String, Object>> statisticsByType();
    
    /**
     * 统计不同行政区域内土壤的平均pH值
     * @param level 行政级别（province/city/county/town）
     * @param year 年份（82、08、16）
     * @return 统计结果
     */
    List<Map<String, Object>> statisticsPhByRegion(String level, String year);
    
    /**
     * 统计指定区域内土壤属性均值
     * @param wkt WKT格式的几何对象字符串
     * @return 统计结果
     */
    Map<String, Object> statisticsByGeometry(String wkt);
} 