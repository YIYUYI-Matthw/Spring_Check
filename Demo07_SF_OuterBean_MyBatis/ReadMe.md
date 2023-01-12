使用06模块部分配置文件：并非在06模块上的更新

```Basic
增加外部Bean（MyBatis）配置模块：07；
加深对MyBatis三个组件的理解：DataSource、SessionFactory、Mapper
MapperConfiguration辅助实现Dao接口的Bean注册
注解`@Configuration`和`@Import`引入方式的区别
```

MyBatis本身有几个毕竟重要的组件：

1. 数据源

   代替用户执行建立连接、会话、sql原生语句生成、执行、关闭会话等操作

   这里采用druid数据源、连接池

2. SessionFactory

   用于开启session，不过现在没有显式声明openSession的操作了：由spring代理

   在这里是使用spring适配的SqlSessionFactory，注册为Bean使用（隐式open session等）
3. Mapper

   将sql操作和功能接口结合起来

   在这里是使用spring适配的MapperConfigurer，辅助将接口注册为Bean（本来是不行的，如BookDao-interface）

接口可以用`@Component`修饰，但其本身无法实例化、进一步注册为Bean

MyBatis的mapperConfigurer肯定是做了一定的操作的：
把interface和sql操作注解结合起来，并且进行了一定程度的接口实现，
因此，可以借助MapperConfigurer来完成BookDao接口注册为Bean

使用Configuration修饰的类会比较早地执行初始化，如果是非初始化用的Bean，可以通过Import方式添加，如Dao、Service类型的Bean
