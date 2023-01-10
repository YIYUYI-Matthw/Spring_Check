package com.yaobukeji;

import com.yaobukeji.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService service = context.getBean(BookService.class);
        service.save();
        context.close();
    }
}