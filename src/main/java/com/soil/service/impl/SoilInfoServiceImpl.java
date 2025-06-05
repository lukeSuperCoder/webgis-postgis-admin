package com.soil.service.impl;

import com.soil.entity.SoilInfo;
import com.soil.mapper.SoilInfoMapper;
import com.soil.service.SoilInfoService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 土壤信息服务实现类
 */
@Service
public class SoilInfoServiceImpl implements SoilInfoService {

    @Resource
    private SoilInfoMapper soilInfoMapper;

    @Override
    public boolean add(SoilInfo soilInfo) {
        return soilInfoMapper.insert(soilInfo) > 0;
    }

    @Override
    public boolean update(SoilInfo soilInfo) {
        return soilInfoMapper.update(soilInfo) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return soilInfoMapper.deleteById(id) > 0;
    }

    @Override
    public SoilInfo getById(Long id) {
        return soilInfoMapper.selectById(id);
    }

    @Override
    public List<SoilInfo> list() {
        return soilInfoMapper.selectList();
    }

    @Override
    public List<SoilInfo> listByCondition(SoilInfo soilInfo) {
        return soilInfoMapper.selectListByCondition(soilInfo);
    }

    @Override
    public List<SoilInfo> listByGeometry(String wkt) {
        return soilInfoMapper.selectByGeometry(wkt);
    }

    @Override
    public List<SoilInfo> listAcidifiedSoil(Double phValue, String wkt) {
        return soilInfoMapper.selectAcidifiedSoil(phValue, wkt);
    }

    @Override
    public Map<String, Object> statisticsByGeometry(String wkt) {
        return soilInfoMapper.statisticsByGeometry(wkt);
    }
} 