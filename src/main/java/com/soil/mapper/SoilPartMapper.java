package com.soil.mapper;

import com.soil.entity.SoilPart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 土壤分区Mapper接口
 */
@Mapper
public interface SoilPartMapper {

    /**
     * 根据ID查询土壤分区信息
     */
    SoilPart selectById(Integer id);

    /**
     * 查询土壤分区列表
     */
    List<SoilPart> selectList();

    /**
     * 条件查询土壤分区信息
     */
    List<SoilPart> selectByCondition(SoilPart soilPart);
    
    /**
     * 根据行政区域查询土壤分区信息
     */
    List<SoilPart> selectByRegion(@Param("province") String province, 
                                  @Param("city") String city,
                                  @Param("county") String county,
                                  @Param("town") String town);
    
    /**
     * 根据空间范围查询土壤分区信息
     * @param wkt WKT格式的几何对象字符串
     * @return 土壤分区信息列表
     */
    List<SoilPart> selectByGeometry(@Param("wkt") String wkt);
    
    /**
     * 查询酸化土壤信息（pH小于指定值）
     * @param phValue pH阈值
     * @param year 年份（82、08、16）
     * @return 土壤分区信息列表
     */
    List<SoilPart> selectAcidifiedSoil(@Param("phValue") Double phValue, @Param("year") String year);
    
    /**
     * 根据时间段查询土壤pH变化情况
     * @param period 时间段（8208、0816、8216）
     * @param changeValue 变化阈值
     * @return 土壤分区信息列表
     */
    List<SoilPart> selectByPhChange(@Param("period") String period, @Param("changeValue") Double changeValue);
    
    /**
     * 查询有机质含量满足条件的土壤信息
     * @param minValue 最小值
     * @param maxValue 最大值
     * @return 土壤分区信息列表
     */
    List<SoilPart> selectByOrganicMatter(@Param("minValue") Double minValue, @Param("maxValue") Double maxValue);
    
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
    List<Map<String, Object>> statisticsPhByRegion(@Param("level") String level, @Param("year") String year);
    
    /**
     * 统计指定区域内土壤属性均值
     * @param wkt WKT格式的几何对象字符串
     * @return 统计结果
     */
    Map<String, Object> statisticsByGeometry(@Param("wkt") String wkt);
} 