package com.soil.entity;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 土壤信息实体类
 */
@Data
public class SoilInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 土壤信息ID
     */
    private Long id;

    /**
     * 地块名称
     */
    private String plotName;

    /**
     * pH值
     */
    private Double ph;

    /**
     * 有机质含量(%)
     */
    private Double organicMatter;

    /**
     * 全氮含量(g/kg)
     */
    private Double totalNitrogen;

    /**
     * 全磷含量(g/kg)
     */
    private Double totalPhosphorus;

    /**
     * 全钾含量(g/kg)
     */
    private Double totalPotassium;

    /**
     * 地块几何数据
     */
    private Object geometry;

    /**
     * 区域编码
     */
    private String regionCode;

    /**
     * 土壤类型编码
     */
    private String soilTypeCode;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
} 