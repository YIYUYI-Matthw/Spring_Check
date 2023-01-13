package com.yaobukeji.config;

import com.yaobukeji.service.LogService;
import com.yaobukeji.service.impl.AccountServiceImpl;
import com.yaobukeji.service.impl.LogServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 声明为配置文件
@Configuration
// properties配置文件位置
@PropertySource("classpath:Jdbc.properties")
// 扫描方式获得Bean：扫描Config获取：数据源、MapperConfigurer、SessionFactory
@ComponentScan({"com.yaobukeji.config"})
// import方式获得Bean：接口不可注册为Bean，所以这里是Impl
@Import({AccountServiceImpl.class, LogServiceImpl.class})
// 开启事务管理
@EnableTransactionManagement
public class SpringConfig {
}