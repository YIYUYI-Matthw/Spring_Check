package com.yaobukeji.dao.impl;

import com.yaobukeji.dao.BookDao;
import org.springframework.beans.factory.InitializingBean;

public class BookDaoImpl implements BookDao, InitializingBean {
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

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("dao被加载了");
    }
}
