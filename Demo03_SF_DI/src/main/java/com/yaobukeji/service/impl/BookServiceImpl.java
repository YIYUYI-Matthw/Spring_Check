package com.yaobukeji.service.impl;

import com.yaobukeji.dao.BookDao;
import com.yaobukeji.service.BookService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

public class BookServiceImpl implements BookService, InitializingBean, DisposableBean {
    BookDao bookDao; // 它应该被赋值为BookDaoImpl

    List<BookDao> bookDaos;

    private String val01;
    private String val02;

    @Override
    public void save() {
        bookDao.save();
    }

    // property注入：集合注入：constructor集合注入同理
    public void setList(List<BookDao> bookDaos) {
        this.bookDaos = bookDaos;
        System.out.println("一共有" + bookDaos.size() + "个dao实例被注入");
    }

    // proper注入方式，在constructor注入中不使用
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    // 自动装配必须提供无参构造
    public BookServiceImpl() {
    }

    // consructor注入方式：提供含参构造注入Bean
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void setVal01(String val01) {
        this.val01 = val01;
        System.out.println("val01" + val01 + "设置完毕");
    }

    public void setVal02(String val02) {
        this.val02 = val02;
        System.out.println("val02" + val02 + "设置完毕");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("service init, done.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("service upto destroy.");
    }
}
