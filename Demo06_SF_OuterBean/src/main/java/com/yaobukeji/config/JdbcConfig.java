package com.yaobukeji.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;

/*
配置Druid外部Bean
 */
public class JdbcConfig {
    @Bean
    public DruidDataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("${jdbc.driver}");
        dataSource.setUrl("${jdbc.url}");
        dataSource.setUsername("${jdbc.username}");
        dataSource.setPassword("${jdbc.password}");
        return dataSource;
    }
}