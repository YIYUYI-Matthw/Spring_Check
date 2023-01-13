package com.yaobukeji.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Advice {
    @Pointcut("execution(public void com.yaobukeji.dao.impl.BookDaoImpl.save())")
    void pt() {
        // 切入点表达式：动作关键字（访问修饰符 返回值 包名.类/接口名.方法名（参数）异常名）
    }

    @Before("pt()")
    void beforeSave() {
        // 在前面增强，增强的内容是pt方法
        System.out.println("增强（前）");
    }

    @After("pt()")
    void afterSave() {
        System.out.println("增强（后）");
    }

    @Around("pt()")
    public void aroundSave(ProceedingJoinPoint joinPoint) throws Throwable {
        // 如果接受返回值，则必须设为Object返回值；不接收可以设定为void
        for (int i = 0; i < 2; i++) {
            System.out.println("执行（前）：" + i);
            joinPoint.proceed();
            System.out.println("执行（后）：" + i);
        }
    }
}