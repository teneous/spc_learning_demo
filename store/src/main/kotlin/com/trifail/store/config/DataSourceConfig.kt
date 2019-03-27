package com.trifail.store.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.io.ClassPathResource
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.init.DataSourceInitializer
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import java.util.*
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

/**
 * copy from store
 */
@Configuration
@EnableJpaRepositories(basePackages = ["com.trifail.store.repository"])
class DataSourceConfig{

    @Value("\${store.mysql.datasource.url}")
    private val url: String? = "jdbc:mysql://localhost:3306/store?characterEncoding=utf8&useSSL=false"
    @Value("\${store.mysql.datasource.driver}")
    private val driver: String? = "com.mysql.cj.jdbc.Driver"
    @Value("\${store.mysql.datasource.username}")
    private val username: String? = "root"
    @Value("\${store.mysql.datasource.password}")
    private val password: String? = "123456"
    @Value("\${store.mysql.datasource.withInitialization}")
    private val initialized: Boolean? = false
    @Value("\${store.jpa.show.sql}")
    private val showSql: Boolean? = false
    @Value("\${store.jpa.ddl.auto}")
    private val ddlAuto: String? = "UPDATE"
    @Value("\${store.jpa.dialect}")
    private val dialect: String? = "org.hibernate.dialect.MySQL8Dialect"
    @Value("\${store.jpa.format_sql}")
    private val formatable: Boolean? = true


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "first.datasource")
    fun mysqlDataSource(): DataSource {
        val build = DataSourceBuilder.create()
                .url(url)
                .driverClassName(driver)
                .username(username)
                .password(password)
                .build()
        return build;
    }

    @Bean
    fun transactionManager(emf: EntityManagerFactory): PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = emf
        return transactionManager
    }

    @Bean
    fun exceptionTranslation(): PersistenceExceptionTranslationPostProcessor {
        return PersistenceExceptionTranslationPostProcessor()
    }

    /**
     * EntityManager
     */
    @Bean
    fun entityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        val factory = LocalContainerEntityManagerFactoryBean()
        factory.dataSource = mysqlDataSource()
        factory.setPackagesToScan("com.trifail.store.model")
        //hibernate jpa
        factory.jpaVendorAdapter = HibernateJpaVendorAdapter()
        //customized proeprties
        val jpaProperties = Properties()
        jpaProperties["hibernate.hbm2ddl.auto"] = ddlAuto!!
        jpaProperties["hibernate.show-sql"] = showSql!!
        jpaProperties["hibernate.dialect"] = dialect!!
        jpaProperties["hibernate.format_sql"] = formatable!!
        factory.setJpaProperties(jpaProperties)
        return factory
    }


    /**
     * 数据库是否初始化
     */
    @Bean
    fun dataSourceInitializer(): DataSourceInitializer {
        val dsInitializer = DataSourceInitializer()
        dsInitializer.setDataSource(mysqlDataSource())
        val dbPopulator = ResourceDatabasePopulator()
        dbPopulator.addScript(ClassPathResource("store_initialization.sql"))
        dsInitializer.setDatabasePopulator(dbPopulator)
        dsInitializer.setEnabled(initialized!!)
        return dsInitializer
    }
}