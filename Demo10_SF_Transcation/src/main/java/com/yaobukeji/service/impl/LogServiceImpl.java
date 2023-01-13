package com.yaobukeji.service.impl;

import com.yaobukeji.dao.LogDao;
import com.yaobukeji.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogServiceImpl implements LogService {
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void logInfo() {
        System.out.println("记录操作");
    }
}
