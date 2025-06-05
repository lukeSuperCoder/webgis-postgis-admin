#!/bin/bash

echo "=== 构建Docker镜像并启动容器 ==="

# 构建并启动容器
docker-compose up -d

echo "=== 等待容器启动 ==="
sleep 10

echo "=== 检查容器状态 ==="
docker ps

echo "=== 应用运行在: http://localhost:8089/soil-api/ ==="
echo "=== Swagger文档: http://localhost:8089/soil-api/swagger-ui.html ===" 