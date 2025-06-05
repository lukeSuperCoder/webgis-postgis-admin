package com.soil.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * PostGIS类型注册器
 */
@Component
public class PostGisTypeRegistrar implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) {
        // 执行SQL验证PostGIS是否安装
        jdbcTemplate.execute("SELECT PostGIS_full_version()");
        
        // 创建PostGIS扩展(如果不存在)
        jdbcTemplate.execute("CREATE EXTENSION IF NOT EXISTS postgis");

        System.out.println("PostGIS扩展已启用");
    }
} 