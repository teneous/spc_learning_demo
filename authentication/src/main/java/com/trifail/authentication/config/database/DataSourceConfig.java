


package com.trifail.authentication.config.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;


import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private ExtraSrouceConfig extraSrouceConfig;

    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .url(extraSrouceConfig.url)
                .driverClassName(extraSrouceConfig.driver)
                .username(extraSrouceConfig.username)
                .password(extraSrouceConfig.password)
                .build();
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer() {
        DataSourceInitializer dsInitializer = new DataSourceInitializer();
        dsInitializer.setDataSource(dataSource());
        ResourceDatabasePopulator dbPopulator = new ResourceDatabasePopulator();
        dbPopulator.addScript(new ClassPathResource("schema.sql"));
        dbPopulator.addScript(new ClassPathResource("data.sql"));
        dsInitializer.setDatabasePopulator(dbPopulator);
        dsInitializer.setEnabled(true);
        return dsInitializer;
    }
}
