package com.soil.service;

import com.soil.entity.SoilInfo;
import java.util.List;
import java.util.Map;

/**
 * 土壤信息服务接口
 */
public interface SoilInfoService {

    /**
     * 添加土壤信息
     */
    boolean add(SoilInfo soilInfo);

    /**
     * 更新土壤信息
     */
    boolean update(SoilInfo soilInfo);

    /**
     * 根据ID删除土壤信息
     */
    boolean delete(Long id);

    /**
     * 根据ID查询土壤信息
     */
    SoilInfo getById(Long id);

    /**
     * 查询所有土壤信息
     */
    List<SoilInfo> list();

    /**
     * 根据条件查询土壤信息列表
     */
    List<SoilInfo> listByCondition(SoilInfo soilInfo);
    
    /**
     * 根据空间范围查询土壤信息
     * @param wkt WKT格式的几何对象字符串
     * @return 土壤信息列表
     */
    List<SoilInfo> listByGeometry(String wkt);
    
    /**
     * 根据条件查询酸化土壤信息
     * @param phValue pH阈值
     * @param wkt 可选，WKT格式的几何对象字符串
     * @return 土壤信息列表
     */
    List<SoilInfo> listAcidifiedSoil(Double phValue, String wkt);
    
    /**
     * 统计指定区域内土壤信息
     * @param wkt WKT格式的几何对象字符串
     * @return 统计结果
     */
    Map<String, Object> statisticsByGeometry(String wkt);
} 