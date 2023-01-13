package com.yaobukeji.dao;

import com.yaobukeji.domain.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Lazy
public interface LogDao {
    @Select("select * from tbl_account")
    List<Account> log();
}
