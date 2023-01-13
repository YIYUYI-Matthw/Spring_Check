SpringMVC：轻量级Web框架

SpringMVC的最大简化就是在响应和请求部分：
Servlet需要为每个功能创建一个类，而~中则只需要在同一个类中添加各种方法即可：它们并不因为get和post设置不同的方法

## 坐标

SpringMVC有自己的jar包，同时由于~是web框架，它也需要servlet的支持：① spring-webmvc（**web**mvc）；② javax.servlet。

此外，SpringmvcConfig和SpringConfig类要分别配置，之后共同由TomCat加载到

## SpringMVC Init

SpringMVC是表现层框架、Spring事务管理业务层、Dao为数据层

对于当前SpringMVC项目而言：它是一个web项目，所以需要：

* 首先创建一个web项目：空mvn+webapp+TomCat配置；


* 它通过TomCat运行，而不是通过Application的引导类方法运行，所以需要将Spring和SpringMVC配置TomCat加载以备使用。

  关于加载配置，spring提供一个AbstractDispatcherServletInitializer类来提示TomCat加载哪些内容，

  这个类内定义抽象三个方法：

    * createServletApplicationContext：mvcConfig

      里面要提供引导类对象（ApplicationContext），不过注意这里提供的是web类型的application并加载mvcConfig.class：`AnnotationConfigWebApp~t`类

      加载mvcConfig配置：`context.register(~.class)`

    * getServletMappings：设置哪些请求（路径）归属springMVC处理："/"：所有请求归mvc处理
    * createRootApplicationContext：springConfig：类比mvcConfig设置，也是在webApplication中register


* 表现层

  主要是Controller。之前使用Servlet为每个请求定义一个类，创建doGet和doPost;

  而~中则是定义一个Controller类，类内每个方法对应一个请求：不通过doGet等来区分请求类型。


* 一个SpringMVC项目最少需要：

    * 它是一个web项目
    * 一个SpringmvcConfig
    * 一个继承了AbstractDispatcher~类的InitializerConfig，供TomCat使用加载spring配置
    * 一个controller.XxController类：至少能处理一个请求

## Bean加载

上面讲，spring和~mvc都有各自的配置类，通常会避免加载到对方的Bean：

一般来说：SpringMVC管理“表现层bean”（servlet那些）；Spring控制“业务bean（Service）”和“功能bean（DataSource等）”。

有三种解决方法：

（1）在Spring和SpringMVCconfig.java中分别配置不同的扫描路径

（2）在SpringMVCconfig.java中配置controller，在SpringConfig中exclude控制器Bean（Filter可以做到这一点）

（3）不区分Spring和SpringMVC环境，加载到同一个环境并由TomCat一并初始化加载