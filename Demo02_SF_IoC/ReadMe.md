在01的基础上增加Bean的别名和作用范围的配置,且增加了Bean的声明周期方法:

① 使用Bean中的"别名-name"和"作用范围-scope"完善Bean配置

* name

  配置别名后,所有引用该Bean的地方都可以通过别名来索引,主要是:DI中的ref;app中的getBean
* scope:作用范围

  主要是针对spring中的单例模式设置的,提供两个选项:singleton(默认);prototype(原型)

    * 使用单例模式

      程序运行过程中会有很多重复操作,如service.save,
      如果每次都重新实例化一个Dao对象,太耗费性能和空间了,于是Bean的作用范围就默认是单例模式,所有涉及DI的地方,
      都默认使用同一个实例

    * 不使用单例模式

      有一些时候就是会实例化多个相同类型的Bean,如转账时就是需要有两个不同的Bean来表示不同的人,
      如果还用单例模式,那就冲突了,此时应该转入原型模式,即prototype

② Bean声明周期相关,并设置相应周期下的行为

* 生命周期
    * 初始化IoC
        * 创建对象:内存分配
        * 执行constructor
        * 执行DI:setDao
        * 执行Bean初始化方法-init()
    * 使用Bean:getBean
    * 销毁Bean-destroy()
* 配置生命周期方法
    * 方法一:在类定义中设定init和destroy方法;在Bean配置中配置`init-method`和`destroy-method`
    * 方法二:实现spring提供的initializingBean和DisposableBean接口及其初始化和销毁方法：实现该接口则不用在xml中配置内容
    * 注意:destroy方法需要手动设置`context.close`,如果不设置则不会执行销毁方法,而是在程序执行完毕后退出
        * 且close方法是在`ClassPathApplicationContextXml`实现类中才有的,`ApplicationContext`接口没有

③ DI中的实例化过程

* 基本要求
    * 成员Bean有无参构造方法
    * 依赖Bean有setDao方法
* 三种Bean实例化方式
    * 设置setDao,spring调用隐式无参构造
    * 设置setDao并在成员Bean中显式定义无参构造方法,在方法体内部增加个性化信息
    * 利用工厂模式,将原本Impl的Bean更改为实现了工厂接口的类,在DI中声明工厂方法factory-method(个人:了解)