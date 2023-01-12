package com.yaobukeji.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@SuppressWarnings("all") // 不想看见warning
@Configuration // 使用Configuration修饰的类会比较早地执行初始化，如果是非初始化用的Bean，可以通过Import方式添加，如Dao、Service类型的Bean
public class MyBatisConfig {
    @Bean
    public SqlSessionFactoryBean getSessionFactory(DataSource dataSource) { // 这里的报错不用管
        // 这里的DataSource作为构造函数的参数，spring实行autowire
        // SqlSessionFactoryBean是spring专门用来建立session工厂的类
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        // 配置数据源（和连接池），这里用的是德鲁伊的：SpringConfig中扫描了：符合DataSource的类对象Bean
        sessionFactory.setDataSource(dataSource);
        // 配置实体类别名，对应于之前mybatis.config.xml中的alias
        sessionFactory.setTypeAliasesPackage("com.yaobukeji.domain");
        return sessionFactory;
    }

    @Bean
    public MapperScannerConfigurer mapperConfig() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.yaobukeji.dao");
        return configurer;
    }
}