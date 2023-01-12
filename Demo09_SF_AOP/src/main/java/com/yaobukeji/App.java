package com.yaobukeji;

import com.yaobukeji.config.SpringConfig;
import com.yaobukeji.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService service = context.getBean("bookService", BookService.class);
        service.save();
    }
}