本模块部分采用07模块：数据库连接模块，通过转账系统来描述spring事务管理

spring事务是在业务层（Service）而非数据层（Dao）对操作进行同步管理

---

实现分析：

①：数据层提供基础操作，指定账户减钱（outMoney），指定账户加钱（inMoney）

②：业务层提供转账操作（transfer），调用减钱与加钱的操作

③：提供2个账号和操作金额执行转账操作

④：基于Spring整合MyBatis环境搭建上述操作

结果分析：

①：程序正常执行时，账户金额A减B加，没有问题

②：程序出现异常后，转账失败，但是异常之前操作成功，异常之后操作失败，整体业务失败

---

```java
// 业务管理前

// Dao.java提供in和out方法
public interface AccountDao {

    @Update("update tbl_account set money = money+100 where name = #{name}")
    int inMoney(@Param("name") String name); // 别名

    @Update("update tbl_account set money = money-100 where name = #{name}")
    int outMoney(@Param("name") String name);
}

// Service.java分别调用完成转账
@Service("BookServiceBean") // 声明为Bean，别名为"..."
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao bookDao;

    @Override
    public void transfer() {
        bookDao.outMoney("Doris");
        bookDao.inMoney("Matthew");
    }
}
```

风险就在于：如果程序在in和out之间出现了错误，就有一方的财产受到损失：在业务层添加事务管理

## 事务角色

分为事务管理员和事务协调员。

MyBatis使用的是JDBC事务（数据层），而Spring则是业务层的事务管理。

我们姑且认为JDBC事务（如inMoney所作的update）是事务协调员；
而多个协调员由一个管理员（transfer）进行同步

## 事务属性

Spring并不会对所有的异常进行回滚：对于RuntimeException或Error：Spring进行回滚

可以设置rollbackFor属性来添加要回滚的异常

事务属性条目就不在这里描述了

## 事务传播行为：propagation

——事务传播行为属于事务属性，但是单拎出来说一下

业务场景：不论转账是否成功，都要记录到log中：
如果只是的`try{in; out}catch{log;}`，则最终不会生效
try-catch：表示人工处理异常了：不会回滚。如果不try-catch：控制台报错：在MVC中有关于异常处理的一些机制！

需要声明log业务为转账业务（int&out）之外的新事务：`Propagation.REQUIRES_NEW)`

`Transactional(propagation = Progation.REQUIRES_NEW`