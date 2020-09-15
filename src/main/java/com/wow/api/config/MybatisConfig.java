package com.wow.api.config;

import com.wow.api.config.annotation.MasterConnection;
import com.wow.api.config.annotation.SlaveConnection;
import com.wow.api.config.property.DatabaseProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = DatabaseConfig.BASE_PACKAGE, annotationClass = MasterConnection.class, sqlSessionFactoryRef = "masterSqlSessionFactory")
class MasterMyBatisConfig extends DatabaseConfig {

    @Bean(name = "masterProperties")
    @ConfigurationProperties("wow.datasource.master")
    public DatabaseProperties slaveDatabaseProperties() {
        return new DatabaseProperties();
    }

    @Bean(name = "masterDataSource")
    public DataSource masterDataSource(@Qualifier("masterProperties") DatabaseProperties masterDatabaseProperties) {
        return dataSourceConfig(masterDatabaseProperties);
    }

    @Bean(name = "masterSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        configureCommonSqlSessionFactory(masterDataSource, sessionFactoryBean);
        return sessionFactoryBean.getObject();
    }

    @Bean(name = "masterTransaction")
    public PlatformTransactionManager transactionManager(@Qualifier("masterDataSource") DataSource masterDataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(masterDataSource);
        transactionManager.setGlobalRollbackOnParticipationFailure(false);
        return transactionManager;
    }
}

@Configuration
@MapperScan(basePackages = DatabaseConfig.BASE_PACKAGE, annotationClass = SlaveConnection.class, sqlSessionFactoryRef = "slaveSqlSessionFactory")
class SlaveMyBatisConfig extends DatabaseConfig {

    @Bean(name = "slaveProperties")
    @ConfigurationProperties("wow.datasource.slave")
    public DatabaseProperties slaveDatabaseProperties() {
        return new DatabaseProperties();
    }

    @Bean(name = "slaveDataSource")
    public DataSource masterDataSource(@Qualifier("slaveProperties") DatabaseProperties slaveDatabaseProperties) {
        return dataSourceConfig(slaveDatabaseProperties);
    }

    @Bean(name = "slaveSqlSessionFactory")
    public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource slaveDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        configureCommonSqlSessionFactory(slaveDataSource, sessionFactoryBean);
        return sessionFactoryBean.getObject();
    }
}