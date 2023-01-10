package com.yaobukeji.service.impl;

import com.yaobukeji.dao.BookDao;
import com.yaobukeji.service.BookService;

public class BookServiceImpl implements BookService {
    BookDao bookDao; // 它应该被赋值为BookDaoImpl

    @Override
    public void save() {
        bookDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
