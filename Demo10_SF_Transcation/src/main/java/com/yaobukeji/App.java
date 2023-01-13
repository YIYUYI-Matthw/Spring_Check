package com.yaobukeji;

import com.yaobukeji.config.SpringConfig;
import com.yaobukeji.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 按类型装配：在这里只有一个实现类，可以不用别名的，只是为了练习
        AccountService service = context.getBean("BookServiceBean", AccountService.class);
        service.transfer();
    }
}