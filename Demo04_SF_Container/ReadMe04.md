【注意】该模块基于01模块建立

主要讨论IoC容器的实例化、Bean对象的获取、Bean延迟加载机制

之前讲到过：spring使用工厂模型建立IoC容器，实际上，早期确实是使用BeanFactory来获取Bean的：

```java
Resource resources=new ClassPathResources("applicationContext.xml");
        BeanFactory factory=new XmlBeanFactory(resources);
// 寻找id为bookDao的Bean，类型转换为BookDao.class后返回
        BookDao dao=factory.getBean("bookDao",BookDao.class);
```

而现在则是在BF接口的基础上做了进一步的封装，直接获取IoC容器来getBean

① IoC容器实例化
上面讲，当前IoC容器是实现了BF接口的类。
而这其中最常用的是两个实现类：`ClassPathXmlApplicationContext`和`FileSystemXmlApplicationContext`

ApplicationContext接口继承了BF接口&是上述两个实现类的父接口

* 加载类路径下的配置文件

  `ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")`
* 文件系统加载配置文件（绝对路径）

  `ApplicaitonContext context = new FileSystemXmlApplicationContext("applicationContext.xml")`
* 加载多个配置文件
  `ApplicationContext context = new ClassPathXmlApplicationContext("appCtx01.xml, appCtx02.xml")`

  （没有试过文件系统加载多个，理论上是一样的）

② Bean获取方式
就是不同方式获取并返回Bean

* Bean-id/name + 强制类型转换
  `BookDao dao = (BookDao)context.getBean("bookDao")`
  这里获取的实际上是`BookDaoImpl`类型的Bean，然后转为BookDao接口类型
* Bean-id/name + 指定类型
  `BookDao dao = context.getBean("bookDao", BookDao.class)`
* 使用Bean类型获取：要求容器中只能有一个该类型的Bean（个人感觉还挺好用的，一般就是一个类型的Bean定义一个）
  `BookDao dao = context.getBean(BookDao.class)`

③ Bean延时加载
Bean的实例化并不会在IoC容器中被定义后就实例化，而是等到有getBean的操作时才进行实例化

在容器中对应的Bean标签内配置：lazy-init="true"
