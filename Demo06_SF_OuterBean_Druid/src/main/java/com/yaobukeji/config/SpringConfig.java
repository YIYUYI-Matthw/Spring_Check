package com.yaobukeji.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
// 引入方式一：import相应配置类：这里面会提供DataSource的Bean
@Import(JdbcConfig.class)
// 引入方式二：扫描config获取外部Bean
@ComponentScan({"com.yaobukeji.config"})
// properties文件：两个方式都使用到了
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {
}