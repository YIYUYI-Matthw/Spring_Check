package com.yaobukeji.dao.impl;

import com.yaobukeji.dao.BookDao;
import com.yaobukeji.service.impl.BookServiceImpl;

public class BookDaoImpl implements BookDao {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("dao init, done.");
    }

    public void destroy() {
        System.out.println("dao upto destroy.");
    }

    @Override
    public void save() {
        System.out.println("save, done.");
    }
}
