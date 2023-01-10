package com.yaobukeji;

import com.yaobukeji.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Bean实例化方式一
        BookService service1 = (BookService) context.getBean("bookServiceBean");
        // Bean实例化方式二
        BookService service2 = context.getBean("bookServiceBean", BookService.class);
        // Bean实例化方式三
        BookService service3 = context.getBean(BookService.class);
        service1.save();
    }
}