package com.yaobukeji.dao;

import com.yaobukeji.domain.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Lazy // 懒加载
/* 尽管添加Component注解，但仅做逻辑上的Bean声明，
注册Bean的过程实际上是借助了MyBatis的mepperConfigurer
 */
public interface BookDao {
    @Select("select * from tbl_account")
    List<Account> checkAll();
}
