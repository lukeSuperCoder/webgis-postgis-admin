# 土壤信息服务平台后端

## 项目介绍
该项目是土壤信息服务平台的后端部分，使用Spring Boot + Spring MVC + MyBatis框架开发，数据库采用PostgreSQL+PostGIS。

## 技术栈
- Java框架: Spring Boot 2.7.3
- Web框架: Spring MVC
- ORM框架: MyBatis
- 数据库: PostgreSQL + PostGIS
- 构建工具: Maven
- API文档: SpringDoc OpenAPI (Swagger) 1.6.15

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
3. 访问API：http://localhost:8089/soil-api/

## API文档

### Swagger接口文档
项目集成了Swagger (OpenAPI 3.0) 接口文档工具，便于API测试：

- Swagger UI界面: http://localhost:8089/soil-api/swagger-ui.html
- API文档JSON: http://localhost:8089/soil-api/api-docs

通过Swagger UI界面可以:
- 查看所有API接口的详细说明
- 在线测试接口功能
- 查看请求和响应模型
- 下载API文档

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

### 土壤分区管理 (新增)
- 根据ID查询: `GET /soil-api/soil-part/get/{id}`
- 查询列表: `GET /soil-api/soil-part/list`
- 条件查询: `GET /soil-api/soil-part/listByCondition`
- 区域查询: `GET /soil-api/soil-part/listByRegion?province=&city=&county=&town=`
- 空间范围查询: `GET /soil-api/soil-part/listByGeometry?wkt=...`
- 酸化土壤查询: `GET /soil-api/soil-part/listAcidifiedSoil?phValue=&year=`
- pH变化查询: `GET /soil-api/soil-part/listByPhChange?period=&changeValue=`
- 有机质含量查询: `GET /soil-api/soil-part/listByOrganicMatter?minValue=&maxValue=`
- 土壤类型面积统计: `GET /soil-api/soil-part/statisticsByType`
- 区域pH值统计: `GET /soil-api/soil-part/statisticsPhByRegion?level=&year=`
- 区域内属性统计: `GET /soil-api/soil-part/statisticsByGeometry?wkt=...`

## 开发指南
1. 拉取代码：`git clone [仓库地址]`
2. 导入项目到IDE
3. 安装依赖：`mvn install`
4. 运行项目：`mvn spring-boot:run` 

## Docker部署

1. 拉取镜像：`docker pull lukesupercoder/soil-backend:latest`
2. 启动PostgreSQL数据库：
```
      # 确认PostgreSQL容器是否正在运行
      docker ps | findstr soil-postgres
      # 确认网络是否已创建
      docker network ls | findstr soil-network

      # 清理现有容器
      docker stop soil-postgres soil-backend
      docker rm soil-postgres soil-backend

      # 确认网络存在，如果不存在则创建
      docker network ls | findstr soil-network
      if ($LASTEXITCODE -ne 0) {
         docker network create soil-network
      }

      # 先启动PostgreSQL容器并等待它完全初始化
      docker run -d --name soil-postgres `
      --network soil-network `
      -p 5432:5432 `
      -e POSTGRES_USER=postgres `
      -e POSTGRES_PASSWORD=postgres `
      -e POSTGRES_DB=gistable `
      docker.1ms.run/postgis/postgis:11-3.3

      # 等待PostgreSQL启动完成（大约需要10-20秒）
      Start-Sleep -Seconds 20

      # 再启动应用容器
      docker run -d --name soil-backend `
      --network soil-network `
      -p 8089:8089 `
      -e SPRING_DATASOURCE_URL=jdbc:postgresql://soil-postgres:5432/gistable `
      -e SPRING_DATASOURCE_USERNAME=postgres `
      -e SPRING_DATASOURCE_PASSWORD=postgres `
      lukesupercoder/soil-backend:latest
```

## 查看Docker容器内PostgreSQL数据库的表
```
   docker exec -it soil-postgres psql -U postgres -d gistable -c "SELECT * FROM soil_part;"
   
   # 进入PostgreSQL容器
   docker exec -it soil-postgres bash

   # 使用psql连接到数据库
   psql -U postgres -d gistable

   # 在psql中列出所有表
   \dt

   # 查看特定表的结构
   \d 表名

   # 执行SQL查询
   SELECT * FROM 表名 LIMIT 5;

   # 退出psql
   \q

   # 退出容器
   exit
```

# 执行建表语句
```
   # 将本地文件复制到容器内
   docker cp init.sql soil-postgres:/tmp/

   # 在容器内执行SQL文件
   docker exec -it soil-postgres psql -U postgres -d gistable -f /tmp/init.sql
```