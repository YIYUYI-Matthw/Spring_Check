package com.yaobukeji.service.impl;

import com.yaobukeji.dao.BookDao;
import com.yaobukeji.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("bookService")
@Scope("singleton")
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao; // 它应该被赋值为BookDaoImpl

    @Override
    public void save() {
        bookDao.save();
    }
}
