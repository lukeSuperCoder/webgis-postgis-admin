package com.soil.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * MyBatis配置类
 */
@Configuration
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;

    /**
     * 配置SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        
        // 设置mapper.xml文件的位置
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        
        // 设置typeAliases包路径
        sessionFactory.setTypeAliasesPackage("com.soil.entity");
        
        return sessionFactory.getObject();
    }
} 