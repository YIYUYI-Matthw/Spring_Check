该模块并未继承上述任意模块，而是引入Druid包进行开发：在模块的pom.xl中配置坐标，这里不用再重复导入mysql-connector的坐标了

对于非自己开发的spring模块，spring提供`@Bean`注解来配合其他注解（就是DI注解）共同将其注册为一个Bean

```java
/* 
下面是@Bean注解的源码，可以看出：@Bean注解的效果相当于是加强版的“自动装配”
    ① 增加name-别名和value（暂时还没弄清楚，待续）
    ② 设置两个生命周期方法，但返回均为默认值，也许需要overwrite：不过一般不用：因为是别人开发的jar包
 */

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Bean {
    @AliasFor("name")
    String[] value() default {};

    @AliasFor("value")
    String[] name() default {};

    /** @deprecated */
    @Deprecated
    Autowire autowire() default Autowire.NO;

    boolean autowireCandidate() default true;

    String initMethod() default "";

    String destroyMethod() default "(inferred)";

}
```

外部Bean的注册：
`@Bean`多数情况下会用于修饰方法，该方法则提供一个定制化的Bean：

① 方法体内首先实例化外部Bean并根据外部Bean的规则进行setter或者constructor注入（通常是各种属性而非依赖的其他Bean，其他Bean为AutoWired）；

② 对外部Bean类完成依赖注入后返回外部Bean并被该注解修饰到；

外部Bean的引用：

① 在配置类中通过`@Import`注解引用到相应的Bean：反射方式配置；

② 用`@Configuration`修饰外部Bean的注册类，并在主导配置类中添加扫描路径获取Bean：注解方式配置。

然后就能正常获取、使用了

驱动配置：[这个讲的很好](https://blog.csdn.net/Camel_LT/article/details/109299205)

DruidDataSource同时提供数据源和连接池，但总是对JDBC的封装，所以一般在使用druid的时候都需要把JDBC的坐标也带上