package com.soil.service.impl;

import com.soil.entity.SoilPart;
import com.soil.mapper.SoilPartMapper;
import com.soil.service.SoilPartService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 土壤分区服务实现类
 */
@Service
public class SoilPartServiceImpl implements SoilPartService {

    @Resource
    private SoilPartMapper soilPartMapper;

    @Override
    public SoilPart getById(Integer id) {
        return soilPartMapper.selectById(id);
    }

    @Override
    public List<SoilPart> list() {
        return soilPartMapper.selectList();
    }

    @Override
    public List<SoilPart> listByCondition(SoilPart soilPart) {
        return soilPartMapper.selectByCondition(soilPart);
    }

    @Override
    public List<SoilPart> listByRegion(String province, String city, String county, String town) {
        return soilPartMapper.selectByRegion(province, city, county, town);
    }

    @Override
    public List<SoilPart> listByGeometry(String wkt) {
        return soilPartMapper.selectByGeometry(wkt);
    }

    @Override
    public List<SoilPart> listAcidifiedSoil(Double phValue, String year) {
        return soilPartMapper.selectAcidifiedSoil(phValue, year);
    }

    @Override
    public List<SoilPart> listByPhChange(String period, Double changeValue) {
        return soilPartMapper.selectByPhChange(period, changeValue);
    }

    @Override
    public List<SoilPart> listByOrganicMatter(Double minValue, Double maxValue) {
        return soilPartMapper.selectByOrganicMatter(minValue, maxValue);
    }

    @Override
    public List<Map<String, Object>> statisticsByType() {
        return soilPartMapper.statisticsByType();
    }

    @Override
    public List<Map<String, Object>> statisticsPhByRegion(String level, String year) {
        return soilPartMapper.statisticsPhByRegion(level, year);
    }

    @Override
    public Map<String, Object> statisticsByGeometry(String wkt) {
        return soilPartMapper.statisticsByGeometry(wkt);
    }
} 