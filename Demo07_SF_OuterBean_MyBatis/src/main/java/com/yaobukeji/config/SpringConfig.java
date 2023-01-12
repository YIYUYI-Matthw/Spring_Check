package com.yaobukeji.config;

import com.yaobukeji.service.impl.BookServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

// 声明为配置文件
@Configuration
// properties配置文件位置
@PropertySource("classpath:Jdbc.properties")
// 扫描方式获得Bean：扫描Config获取：数据源、MapperConfigurer、SessionFactory
@ComponentScan({"com.yaobukeji.config"})
// import方式获得Bean：接口不可注册为Bean，所以这里是Impl
@Import({BookServiceImpl.class})
public class SpringConfig {
}