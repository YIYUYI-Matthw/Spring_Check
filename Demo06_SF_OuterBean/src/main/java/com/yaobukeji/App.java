package com.yaobukeji;

import com.alibaba.druid.pool.DruidDataSource;
import com.yaobukeji.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataSource dataSource = context.getBean(DruidDataSource.class); // 这个Bean就是在JdbcConfig中提供的DataSource了
        System.out.println(dataSource);
    }
}
