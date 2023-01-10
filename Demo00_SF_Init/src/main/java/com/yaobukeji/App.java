package com.yaobukeji;

import com.yaobukeji.service.BookService;
import com.yaobukeji.service.impl.BookServiceImpl;

public class App {
    public static void main(String[] args) {
        BookService service = new BookServiceImpl();
        service.save();
    }
}