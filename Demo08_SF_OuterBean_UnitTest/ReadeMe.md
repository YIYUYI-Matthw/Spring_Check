基于05（注解开发）增加单元测试模块

需要单元测试模块和spring-test两个模块的支持

spring要求测试中的目录结构要和"/java"下的一致：测试类的包名要和src中的目录同名（APP的路径），否则Spring boot junit无法注入对象的依赖关系

[这篇讲的不错](https://www.jianshu.com/p/993a1731f566)

加载Bean对象时，要像引导类一样增加`@ContextConfiguration`配置SpringConfig，
在需要做单元测试的方法上增加方法注解`@Test`，
其他如自动装配等操作和之前一致

```java
@RunWith就是一个运行器
@RunWith(JUnit4.class) // 就是指用JUnit4来运行
@RunWith(SpringJUnit4ClassRunner.class) // 让测试运行于Spring测试环境
@RunWith(Suite.class) // 是一套测试集合

/*
作者：墨色尘埃
链接：https://www.jianshu.com/p/993a1731f566
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
```