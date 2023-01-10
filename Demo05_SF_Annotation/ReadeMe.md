该模块在模块00的基础上增加注解开发，具体包括：IoC容器配置类注解、Bean扫描路径注解、properties文件配置注解、Bean声明注解、Bean作用范围注解、Bean生命周期注解、DI注解等

从Spring2.0开始有注解开发的形式，3.0则调整为纯注解开发。

注解开发两个阶段：

* Bean注解

  原本在xml（IoC容器）中定义的Bean以及DI通过注解形式给到，同时增加`<context:component-scan>`标签配置Bean扫描路径，从而正常加载Bean、DI。
* 纯注解开发
  将xml配置文件舍弃，而是增加配置类：添加类注解`@Configuration`声明为配置类，并通过`@ComponentScan`注解配置Bean扫描路径。

  此外，就像之前实例化xml配置的IoC容器可以引入多个xml文件一样，可以给多个类添加注解`@Configuration`以提供更加全面的功能

    * IoC容器实例化
      不再通过给定配置文件路径形式初始化IoC容器，而是通过向另一个类`AnnotationConfigApplicationContext`传入配置类来初始化IoC容器

  对于多个配置类：一般会有一个类为主导，通常是`SpringConfig.class`，其他配置类则会被配置到主导配置类的“扫描路径”中，从而提供各个Bean

① 注解开发一阶段

* Bean注解
  普通Bean注解为`@Component`，之后根据功能架构，发展出三个衍生注解
    * Repository：用于数据层Bean定义：Dao
    * Service：用于业务层Bean定义：Serivce
    * Controller：用于表现层Bean定义：Servlet

② Bean作用范围及生命周期注解

* `@Scope`

  传入参数决定Bean作用范围：singleton, prototype
* `@PostConstruct`：方法注解

  在Bean类定义中声明为init后阶段调用的方法上增加`PostConstruct`注解修饰
* `@PreDestroy`：方法注解

  在Bean类定义中声明为destroy前阶段调用的方法上增加`PreDestroy`注解修饰

③ IoC容器配置注解

* `@Configuration`

  声明修饰的类为IoC配置类
* `@ComponentScan`

  修饰IoC容器配置类：传入Bean扫描路径
* `@PropertySource`
  传入properties文件路径标记properties文件位置

④ 注解实现DI：属性注解

注解实现Bean的DI仅提供自动装配，没有setter和constructor依赖注入方式

* 基本类型（包括String）

  在变量上增加`@Value`注解并传入相关数据，一般来说，数据会被配置到properties文件中
* 引用类型（基本特指Bean）

  在成员Bean上增加`@Autowire`注解，配合配置类中的Bean扫描路径，spring自动调用成员Bean（及其实现类）对应的无参构造实例化Bean并返回

  在`getBean(BookService.class)`时，虽然参数是BookService类，但获得的却是其**被Bean注解修饰的实现子类**，这一点可以通过Bean实例化的三种方式来理解：

  当前是第三种：传入类别进行getBean操作，而更易理解的是其他两种，如`getBean("bookService", BookService.class)`

**提问**：在注解开发模式下，含参构造如何配置？
对于含参构造（或者其他方法？待续），其形参默认按照AutoWire方式配置，通过使用`@ComponentScan`注解修饰该方法所在类，则spring自动扫描并且装配