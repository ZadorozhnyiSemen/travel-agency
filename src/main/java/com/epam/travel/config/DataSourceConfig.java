package com.epam.travel.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

@Configuration
public class DataSourceConfig {

    @Bean
    public ComboPooledDataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("org.postgresql.Driver");
            dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/travelagency");
            dataSource.setUser("postgres");
            dataSource.setPassword("123");

            dataSource.setMinPoolSize(2);
            dataSource.setAcquireIncrement(3);
            dataSource.setMaxPoolSize(10);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        return dataSource;
    }
}
