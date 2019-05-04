package com.trifail.order.config.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.trifail.order.repository")
public class DataSourceConfig {

    @Autowired
    private ExtraSrouceConfig extraSrouceConfig;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "first.datasource")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create()
                .url(extraSrouceConfig.url)
                .driverClassName(extraSrouceConfig.driver)
                .username(extraSrouceConfig.username)
                .password(extraSrouceConfig.password)
                .build();
    }

    /**
     * 事务管理著接口
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /**
     * EntityManager
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(mysqlDataSource());
        factory.setPackagesToScan("com.trifail.order.model");
        //hibernate jpa
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        //customized proeprties
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", extraSrouceConfig.ddlAuto);
        jpaProperties.put("hibernate.show-sql", extraSrouceConfig.showSql);
        jpaProperties.put("hibernate.dialect", extraSrouceConfig.dialect);
        jpaProperties.put("hibernate.format_sql", extraSrouceConfig.formatable);
        factory.setJpaProperties(jpaProperties);
        return factory;
    }


    /**
     * 数据库是否初始化
     */
    @Bean
    public DataSourceInitializer dataSourceInitializer() {
        DataSourceInitializer dsInitializer = new DataSourceInitializer();
        dsInitializer.setDataSource(mysqlDataSource());
        ResourceDatabasePopulator dbPopulator = new ResourceDatabasePopulator();
        dbPopulator.addScript(new ClassPathResource("order_initialization.sql"));
        dsInitializer.setDatabasePopulator(dbPopulator);
        dsInitializer.setEnabled(extraSrouceConfig.initialized);
        return dsInitializer;
    }
}
