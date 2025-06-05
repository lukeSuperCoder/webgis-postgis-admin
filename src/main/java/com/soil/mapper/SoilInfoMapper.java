package com.soil.mapper;

import com.soil.entity.SoilInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 土壤信息Mapper接口
 */
@Mapper
public interface SoilInfoMapper {

    /**
     * 添加土壤信息
     */
    int insert(SoilInfo soilInfo);

    /**
     * 更新土壤信息
     */
    int update(SoilInfo soilInfo);

    /**
     * 根据ID删除土壤信息
     */
    int deleteById(Long id);

    /**
     * 根据ID查询土壤信息
     */
    SoilInfo selectById(Long id);

    /**
     * 查询所有土壤信息
     */
    List<SoilInfo> selectList();

    /**
     * 根据条件查询土壤信息列表
     */
    List<SoilInfo> selectListByCondition(SoilInfo soilInfo);
    
    /**
     * 根据空间范围查询土壤信息
     * @param wkt WKT格式的几何对象字符串
     * @return 土壤信息列表
     */
    List<SoilInfo> selectByGeometry(@Param("wkt") String wkt);
    
    /**
     * 根据条件查询酸化土壤信息（pH小于指定值）
     * @param phValue pH阈值
     * @param wkt 可选，WKT格式的几何对象字符串
     * @return 土壤信息列表
     */
    List<SoilInfo> selectAcidifiedSoil(@Param("phValue") Double phValue, @Param("wkt") String wkt);
    
    /**
     * 统计指定区域内土壤信息
     * @param wkt WKT格式的几何对象字符串
     * @return 统计结果
     */
    Map<String, Object> statisticsByGeometry(@Param("wkt") String wkt);
} 