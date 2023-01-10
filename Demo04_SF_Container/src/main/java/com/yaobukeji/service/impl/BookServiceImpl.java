package com.yaobukeji.service.impl;

import com.yaobukeji.dao.BookDao;
import com.yaobukeji.service.BookService;
import org.springframework.beans.factory.InitializingBean;

public class BookServiceImpl implements BookService, InitializingBean {
    BookDao bookDao; // 它应该被赋值为BookDaoImpl

    @Override
    public void save() {
        bookDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("service被加载了");
    }
}
