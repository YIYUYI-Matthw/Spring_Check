package com.yaobukeji.service.impl;

import com.yaobukeji.dao.BookDao;
import com.yaobukeji.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BookServiceBean") // 声明为Bean，别名为"..."
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public void checkAll() {
        System.out.println(bookDao.checkAll());
    }
}
