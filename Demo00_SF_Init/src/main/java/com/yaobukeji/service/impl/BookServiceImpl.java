package com.yaobukeji.service.impl;

import com.yaobukeji.dao.BookDao;
import com.yaobukeji.dao.impl.BookDaoImpl;
import com.yaobukeji.service.BookService;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl(); // 它应该被赋值为BookDaoImpl

    @Override
    public void save() {
        bookDao.save();
    }
}
