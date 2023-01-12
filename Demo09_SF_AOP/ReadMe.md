该模块以05为基础，移除了自定义Bean生命周期方法，增加AOP内容，演示了Before、After、Around

AOP模块依赖spring-aop（spring-fm依赖aop，所以不用再导入）和切面Aspect模块：在SpringConfige类上添加`@EnableAspectAutoProxy`

## AOP基本概念

AOP：Aspect Oriented Programming，面向切面编程

其作用在于”无侵入“式地对系统功能（某个方法）进行加强，可以和sql注入想类比：在不改变局部代码的情况下变更其功能。

实际上，spring是通过代理模式做到这一点的：被代理（即将加强）的Bean称之为目标对象，spring会为目标创建一个代理对象，
这个代理对象有着对目标对象原始方法进行增强后的方法，然后spring就会用代理对象创建的Bean来执行任务。

### terminologies

* 通知（Advice）：一个类，内部定义了若干的增强策略（以一个被修饰的空方法形式呈现）
* 通知类型：有Before, After, Around, AfterReturning, AfterThrowing等五种类型，主要描述了增强策略在被增强方法中所处位置（是在被增强方法前执行还是在后执行）
* 连接点：一个Bean中可以被增强的方法（其实基本都可以）
* 切入点：被增强的方法（个人：实际操作中是用于增强方法的方法）
* 切面：被`@Aspect`修饰的Advice类，切面定义了切入点和通知之间的关系，就类比DI吧
* 目标对象（Target）：被代理的原始对象（就是被增强的对象）称为目标对象

```java
import org.springframework.stereotype.Component;

@Component
class Obj_Naive {
    void JointPointMethod() {
        System.out.println("要被增强了！");
    }
}

@Component
@Aspect
class Advice {
    @PointCut("enhance action")
    void pointCut() {
    }

    @Before("pointCut()")
        // 指示通知类型与切入点方法
    void JointPointMethod(ProceedingJoinPoint jointPoint) {
        // 习惯上方法名保持一致，但其实不影响
        // jointPoint是原始连接点的一个代理（目标对象）：不用的话可以不写，如果没有返回值的话，也可以使用JointPoint（~.getArgs获取实参）
        System.out.println("增强方法执行");
    }
}

/* output
    增强方法执行
    要被增强了！
 */
```

## AOP语法（切入点表达式）

`@Before(动作关键字(execution等)（访问修饰符 返回值 包名.类/接口名.方法名（参数）异常名）)`

```Basic
@Aspect：定义切面类，将被标识的类作为一个切面bean
@Pointcut：切点
@Around：环绕增强
@Before：前置增强
@AfterReturning：后置增强—方法正常退出时执行
@AfterThrowing：后置增强—方法异常执行
@After：后置增强—增强anyway
————————————————
版权声明：本文为CSDN博主「Survivior_Y」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_43533825/article/details/108606356
```

执行规则：
【(Around-before)--([Before]-proceed-[After])--(Around-after)】（没有考虑抛出异常）