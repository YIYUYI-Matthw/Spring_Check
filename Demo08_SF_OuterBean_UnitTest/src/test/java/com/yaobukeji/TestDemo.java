package com.yaobukeji;

import com.yaobukeji.config.SpringConfig;
import com.yaobukeji.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class) // 类比ApplicationContext的建立
public class TestDemo {
    @Autowired
    BookService bookService;

    @Test
    public void say() {
        bookService.save();
    }
}