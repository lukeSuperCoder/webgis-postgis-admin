# 福建省土壤信息服务平台后端

## 项目介绍
该项目是福建省土壤信息服务平台的后端部分，使用Spring Boot + Spring MVC + MyBatis框架开发，数据库采用PostgreSQL+PostGIS。

## 技术栈
- Java框架: Spring Boot 2.7.3
- Web框架: Spring MVC
- ORM框架: MyBatis
- 数据库: PostgreSQL + PostGIS
- 构建工具: Maven

## 功能特性
- 用户登录及用户信息管理功能
- 土壤要素查询等基本属性查询功能
- 专题图可视化功能支持
- 高级统计功能（如拉框统计某范围内土壤酸化情况）

## 快速开始

### 环境要求
- JDK 11+
- Maven 3.6+
- PostgreSQL 11+ (带PostGIS扩展)

### 数据库准备
1. 安装PostgreSQL和PostGIS扩展
2. 创建名为`gistable`的数据库（如果尚未创建）
   ```bash
   createdb -U luke gistable
   ```
3. 执行初始化SQL脚本创建表结构和初始数据：
   ```bash
   psql -U luke -d gistable -f src/main/resources/db/init.sql
   ```

### 运行项目
1. 修改`application.yml`中的数据库连接配置（已配置为连接gistable数据库）
2. 执行以下命令启动项目：
   ```bash
   mvn spring-boot:run
   ```
3. 访问API：http://localhost:8080/soil-api/

## API文档

### 用户管理
- 用户登录: `POST /soil-api/user/login`
- 添加用户: `POST /soil-api/user/add`
- 更新用户: `PUT /soil-api/user/update`
- 删除用户: `DELETE /soil-api/user/delete/{id}`
- 查询用户: `GET /soil-api/user/get/{id}`
- 用户列表: `GET /soil-api/user/list`

### 土壤信息管理
- 添加土壤信息: `POST /soil-api/soil/add`
- 更新土壤信息: `PUT /soil-api/soil/update`
- 删除土壤信息: `DELETE /soil-api/soil/delete/{id}`
- 查询土壤信息: `GET /soil-api/soil/get/{id}`
- 土壤信息列表: `GET /soil-api/soil/list`
- 条件查询土壤信息: `GET /soil-api/soil/listByCondition`
- 空间范围查询土壤信息: `GET /soil-api/soil/listByGeometry?wkt=...`
- 查询酸化土壤信息: `GET /soil-api/soil/listAcidifiedSoil?phValue=...&wkt=...`
- 统计分析: `GET /soil-api/soil/statistics?wkt=...`

## 开发指南
1. 拉取代码：`git clone [仓库地址]`
2. 导入项目到IDE
3. 安装依赖：`mvn install`
4. 运行项目：`mvn spring-boot:run` 