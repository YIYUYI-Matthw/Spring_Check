package com.yaobukeji.domain;

public class Account {
    private Integer money; // 默认值null而不是0
    private String name;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + money +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
