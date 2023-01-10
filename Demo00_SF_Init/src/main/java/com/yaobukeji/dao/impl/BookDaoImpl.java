package com.yaobukeji.dao.impl;

import com.yaobukeji.dao.BookDao;

public class BookDaoImpl implements BookDao {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println("save, done.");
    }
}
