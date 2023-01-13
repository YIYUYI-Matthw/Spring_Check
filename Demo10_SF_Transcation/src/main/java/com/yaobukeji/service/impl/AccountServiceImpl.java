package com.yaobukeji.service.impl;

import com.yaobukeji.dao.AccountDao;
import com.yaobukeji.service.AccountService;
import com.yaobukeji.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("BookServiceBean") // 声明为Bean，别名为"..."
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao bookDao;
    @Autowired
    LogService logService;

    @Override
    @Transactional(rollbackFor = ArithmeticException.class)
    public void transfer() {
        int line_change1 = bookDao.outMoney("Doris");
        int a = 1 / 0; // 模拟错误：这个是算术异常：不在默认回滚异常内，要加上
        int line_change2 = bookDao.inMoney("Matthew");
        // log：已定义为新事务
        logService.logInfo();
    }
}