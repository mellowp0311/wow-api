package com.wow.api.config;

import com.wow.api.config.property.DatabaseProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

public abstract class DatabaseConfig {

    protected static final String BASE_PACKAGE = "com.wow";
    protected static final String MAPPER_LOCATIONS = "classpath:sqlMappers/**/*.xml";
    protected static final String MYBATIS_CONFIG = "mybatis-config.xml";

    protected void configureCommonSqlSessionFactory(DataSource dataSource, SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATIONS));
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
    }

    protected DataSource dataSourceConfig(DatabaseProperties source) {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(source.getDriverClassName());
        config.setJdbcUrl(source.getUrl());
        config.setUsername(source.getUsername());
        config.setPassword(source.getPassword());
        return new HikariDataSource(config);
    }
}




