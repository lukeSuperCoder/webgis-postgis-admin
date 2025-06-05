package com.soil.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.io.Serializable;

/**
 * 土壤分区信息实体类
 */
@Data
public class SoilPart implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;
    
    /**
     * 几何数据
     */
    @JsonIgnore
    private Object geom;
    
    /**
     * Join Count
     */
    private Integer joinCount;
    
    /**
     * Target FID
     */
    private Integer targetFid;
    
    /**
     * 省名称
     */
    private String provinceName;
    
    /**
     * 县名称
     */
    private String countyName;
    
    /**
     * 乡名称
     */
    private String townName;
    
    /**
     * 地类名称
     */
    private String landTypeName;
    
    /**
     * 省土壤代码
     */
    private String provinceSoilCode;
    
    /**
     * 省土壤名称
     */
    private String provinceSoilName;
    
    /**
     * 省土类名称
     */
    private String provinceSoilTypeName;
    
    /**
     * 省亚类名称
     */
    private String provinceSubSoilName;
    
    /**
     * 省土属名称
     */
    private String provinceSoilAttrName;
    
    /**
     * 省土种名称
     */
    private String provinceSoilBreedName;
    
    /**
     * 耕层厚度
     */
    private Double ploughLayerThickness;
    
    /**
     * 障碍层厚度
     */
    private Double barrierLayerThickness;
    
    /**
     * 有机质
     */
    private Double organicMatter;
    
    /**
     * 碱解氮
     */
    private Double alkalineNitrogen;
    
    /**
     * 有效磷
     */
    private Double availablePhosphorus;
    
    /**
     * 速效钾
     */
    private Double availablePotassium;
    
    /**
     * CEC
     */
    private Double cec;
    
    /**
     * 缓效钾
     */
    private Double slowReleasePotassium;
    
    /**
     * 交换性钙
     */
    private Double exchangeableCalcium;
    
    /**
     * 交换性镁
     */
    private Double exchangeableMagnesium;
    
    /**
     * 坡度
     */
    private Double slope;
    
    /**
     * 坡向
     */
    private String aspect;
    
    /**
     * 海拔
     */
    private Double elevation;
    
    /**
     * 国际制质地
     */
    private String internationalTexture;
    
    /**
     * 耕层含盐量
     */
    private Double ploughLayerSalt;
    
    /**
     * 灌溉条件
     */
    private String irrigationCondition;
    
    /**
     * 县土壤代码
     */
    private String countySoilCode;
    
    /**
     * 粉粒
     */
    private Double siltContent;
    
    /**
     * 粘粒
     */
    private Double clayContent;
    
    /**
     * 砂砾
     */
    private Double sandContent;
    
    /**
     * 全氮
     */
    private Double totalNitrogen;
    
    /**
     * 排涝能力
     */
    private Double drainageCapacity;
    
    /**
     * 容重
     */
    private Double bulkDensity;
    
    /**
     * 密度
     */
    private Double density;
    
    /**
     * 市名称
     */
    private String cityName;
    
    /**
     * BSM1113
     */
    private Integer bsm1113;
    
    /**
     * 极端低温
     */
    private Double extremeLowTemp;
    
    /**
     * 气候带
     */
    private String climateZone;
    
    /**
     * 坡度2016
     */
    private Double slope2016;
    
    /**
     * 坡向2016
     */
    private Double aspect2016;
    
    /**
     * HB
     */
    private Double hb;
    
    /**
     * XM
     */
    private Integer xm;
    
    /**
     * 氮肥施用量
     */
    private Double nitrogenFertilizer;
    
    /**
     * 82-08变化
     */
    private Double change8208;
    
    /**
     * 08-16变化
     */
    private Double change0816;
    
    /**
     * 面积
     */
    private Double fArea;
    
    /**
     * 平差面积16
     */
    private Double adjustedArea16;
    
    /**
     * 年均温
     */
    private Double annualTemperature;
    
    /**
     * 年降水量
     */
    private Double annualPrecipitation;
    
    /**
     * 地貌
     */
    private String landform;
    
    /**
     * 熟制
     */
    private String maturity;
    
    /**
     * 磷肥施用量
     */
    private Double phosphateFertilizer;
    
    /**
     * 降雨pH
     */
    private Double rainPh;
    
    /**
     * 1982年pH
     */
    private Double ph82;
    
    /**
     * 2008年pH
     */
    private Double ph08;
    
    /**
     * 2016年pH
     */
    private Double ph16;
    
    /**
     * 1982年PA
     */
    private Double pa82;
    
    /**
     * 2008年PA
     */
    private Double pa08;
    
    /**
     * 2016年PA
     */
    private Double pa16;
    
    /**
     * 1982-2016年pH变化
     */
    private Double phChange8216;
    
    /**
     * 1982-2016年PA变化
     */
    private Double paChange8216;
    
    /**
     * N值
     */
    private Double n;
    
    /**
     * P值
     */
    private Double p;
    
    /**
     * BSM
     */
    private Integer bsm;
    
    /**
     * 土壤容重
     */
    private Double soilBulkDensity;
    
    /**
     * 石灰用量
     */
    private Double limeDosage;
    
    /**
     * 耕层厚度1
     */
    private Double ploughLayerThickness1;
    
    /**
     * 海拔分区
     */
    private String elevationZone;
    
    /**
     * 道路间距
     */
    private String roadSpacing;
    
    /**
     * 石灰分区
     */
    private Integer limeZone;
    
    /**
     * PA分区8208
     */
    private Integer paZone8208;
    
    /**
     * PA分区0816
     */
    private Integer paZone0816;
    
    /**
     * 石灰分区1
     */
    private Integer limeZone1;
    
    /**
     * 降水pH
     */
    private Double precipitationPh;
    
    /**
     * 酸化分区
     */
    private Integer acidificationZone;
    
    /**
     * 道路分区
     */
    private String roadZone;
    
    /**
     * 耕层厚度2
     */
    private Double ploughLayerThickness2;
    
    /**
     * 石灰
     */
    private Double lime;
    
    /**
     * 单位面积
     */
    private Double unitArea;
    
    /**
     * 海拔异常
     */
    private Integer elevationAnomaly;
    
    /**
     * 石灰分区12
     */
    private Integer limeZone12;
    
    /**
     * 石灰23
     */
    private Double lime23;
    
    /**
     * GT_10_DEGR
     */
    private Double gt10Degr;
    
    /**
     * 向
     */
    private String xiang;
} 