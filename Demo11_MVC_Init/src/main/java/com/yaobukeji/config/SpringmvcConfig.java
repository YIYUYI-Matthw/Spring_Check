package com.yaobukeji.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.yaobukeji.controller") // MVC需要controller的Bean
@EnableWebMvc // 支持json（included）
public class SpringmvcConfig {
}