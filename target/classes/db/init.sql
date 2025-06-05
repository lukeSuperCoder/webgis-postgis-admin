-- 启用PostGIS扩展（如果尚未启用）
CREATE EXTENSION IF NOT EXISTS postgis;

-- 创建用户表
CREATE TABLE IF NOT EXISTS tb_user (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    real_name VARCHAR(50),
    phone VARCHAR(20),
    email VARCHAR(100),
    status INTEGER DEFAULT 1,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 创建土壤信息表
CREATE TABLE IF NOT EXISTS tb_soil_info (
    id SERIAL PRIMARY KEY,
    plot_name VARCHAR(100) NOT NULL,
    ph NUMERIC(5,2),
    organic_matter NUMERIC(6,2),
    total_nitrogen NUMERIC(6,2),
    total_phosphorus NUMERIC(6,2),
    total_potassium NUMERIC(6,2),
    geometry GEOMETRY(GEOMETRY, 4326),
    region_code VARCHAR(20),
    soil_type_code VARCHAR(20),
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 创建土壤信息表
CREATE TABLE IF NOT EXISTS trsh_part (
	id serial4 NOT NULL,
	geom public.geometry(multipolygon, 3857) NULL,
	join_count int4 NULL,
	target_fid int4 NULL,
	省名称 varchar(30) NULL,
	县名称 varchar(30) NULL,
	乡名称 varchar(30) NULL,
	地类名称 varchar(20) NULL,
	省土壤代码 varchar(8) NULL,
	省土壤名称 varchar(80) NULL,
	省土类名称 varchar(20) NULL,
	省亚类名称 varchar(20) NULL,
	省土属名称 varchar(20) NULL,
	省土种名称 varchar(20) NULL,
	耕层厚度 float8 NULL,
	障碍层厚度 float8 NULL,
	有机质 float8 NULL,
	碱解氮 float8 NULL,
	有效磷 float8 NULL,
	速效钾 float8 NULL,
	cec float8 NULL,
	缓效钾 float8 NULL,
	交换性钙 float8 NULL,
	交换性镁 float8 NULL,
	坡度 float8 NULL,
	坡向 varchar(20) NULL,
	海拔 float8 NULL,
	国际制质地 varchar(20) NULL,
	耕层含盐量 float8 NULL,
	灌溉条件 varchar(10) NULL,
	县土壤代码 varchar(8) NULL,
	粉粒 float8 NULL,
	粘粒 float8 NULL,
	砂砾 float8 NULL,
	全氮 float8 NULL,
	排涝能力 float8 NULL,
	容重 float8 NULL,
	密度 float8 NULL,
	市名称 varchar(50) NULL,
	bsm1113 int4 NULL,
	极端低温jz float8 NULL,
	气候带 varchar(50) NULL,
	坡度2016 float8 NULL,
	坡向2016 float8 NULL,
	hb float8 NULL,
	xm int4 NULL,
	氮肥施用量 float8 NULL,
	"82_08" float8 NULL,
	"08_16" float8 NULL,
	f_area float8 NULL,
	平差面积16 float8 NULL,
	年均温 float8 NULL,
	年降水量 float8 NULL,
	地貌 varchar(50) NULL,
	熟制 varchar(50) NULL,
	磷肥施用量 float8 NULL,
	降雨ph float8 NULL,
	"82ph" float8 NULL,
	"08ph" float8 NULL,
	"16ph" float8 NULL,
	"82pa" float8 NULL,
	"08pa" float8 NULL,
	"16pa" float8 NULL,
	"82_16ph" float8 NULL,
	"82_16pa" float8 NULL,
	n float8 NULL,
	p float8 NULL,
	bsm int4 NULL,
	土壤容重 float8 NULL,
	石灰用量 float8 NULL,
	耕层厚度1 float8 NULL,
	海拔分区 varchar(20) NULL,
	道路间距 varchar(15) NULL,
	石灰分区 int4 NULL,
	pa分区8208 int4 NULL,
	pa分区0816 int4 NULL,
	石灰分区1 int4 NULL,
	降水ph float8 NULL,
	酸化分区 int4 NULL,
	道路分区 varchar(30) NULL,
	耕层厚度2 float8 NULL,
	石灰 float8 NULL,
	单位面积 float8 NULL,
	海拔异常 int4 NULL,
	石灰分区12 int4 NULL,
	石灰23 int4 NULL,
	gt_10_degr float8 NULL,
	xiang varchar(30) NULL,
	CONSTRAINT trsh_part_pkey PRIMARY KEY (id)
);

-- 创建空间索引
CREATE INDEX IF NOT EXISTS idx_soil_info_geometry ON tb_soil_info USING GIST (geometry);

-- 插入默认管理员用户，密码为123456
INSERT INTO tb_user (username, password, real_name, status)
VALUES ('admin', '123456', '系统管理员', 1)
ON CONFLICT (username) DO NOTHING;

-- 插入示例土壤数据（如果表为空）
DO $$
BEGIN
    IF (SELECT COUNT(*) FROM tb_soil_info) = 0 THEN
        INSERT INTO tb_soil_info (plot_name, ph, organic_matter, total_nitrogen, total_phosphorus, total_potassium, geometry, region_code, soil_type_code)
        VALUES 
        ('测试地块1', 6.5, 2.3, 1.2, 0.8, 15.6, ST_GeomFromText('POLYGON((118.1 26.1, 118.2 26.1, 118.2 26.2, 118.1 26.2, 118.1 26.1))', 4326), '350100', 'ST001'),
        ('测试地块2', 5.8, 1.8, 0.9, 0.6, 12.3, ST_GeomFromText('POLYGON((118.3 26.3, 118.4 26.3, 118.4 26.4, 118.3 26.4, 118.3 26.3))', 4326), '350200', 'ST002'),
        ('测试地块3', 7.2, 3.1, 1.5, 1.1, 18.5, ST_GeomFromText('POLYGON((118.5 26.5, 118.6 26.5, 118.6 26.6, 118.5 26.6, 118.5 26.5))', 4326), '350300', 'ST003');
    END IF;
END
$$; 