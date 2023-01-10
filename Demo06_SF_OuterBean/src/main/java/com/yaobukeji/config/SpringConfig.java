package com.yaobukeji.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.yaobukeji.config") // 其实没啥要扫描的
@Import(JdbcConfig.class) // 这里面会提供DataSource的Bean
public class SpringConfig {
}
