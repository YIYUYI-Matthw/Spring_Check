package com.yaobukeji.dao.impl;

import com.yaobukeji.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository("bookDao") // 提供Bean名称，可以通过getBean(name, class)形式获取
public class BookDaoImpl implements BookDao {
    @Value("${bookName}")
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public void save() {
        System.out.println("save, done.");
    }
}