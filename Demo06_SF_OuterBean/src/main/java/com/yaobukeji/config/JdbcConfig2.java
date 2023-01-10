package com.yaobukeji.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
配置Druid外部Bean
 */
@Configuration
public class JdbcConfig2 {
    @Bean
    public DruidDataSource getDataSource() {
        return new DruidDataSource();
    }
}