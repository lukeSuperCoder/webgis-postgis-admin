# 使用多阶段构建
# 构建阶段
FROM docker.1ms.run/library/maven:3.8-openjdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 运行阶段
FROM docker.1ms.run/library/openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "app.jar"] 