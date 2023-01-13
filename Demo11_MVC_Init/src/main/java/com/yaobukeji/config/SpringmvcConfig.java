package com.yaobukeji.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.yaobukeji.controller") // MVC需要controller的Bean
public class SpringmvcConfig {
}
