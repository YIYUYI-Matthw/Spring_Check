package com.yaobukeji.dao;

import com.yaobukeji.domain.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Lazy // 懒加载
/* 尽管添加Component注解，但仅做逻辑上的Bean声明，
注册Bean的过程实际上是借助了MyBatis的mepperConfigurer
 */
public interface AccountDao {

    @Update("update tbl_account set money = money+100 where name = #{name}")
    int inMoney(@Param("name") String name); // 别名

    @Update("update tbl_account set money = money-100 where name = #{name}")
    int outMoney(@Param("name") String name);
}
