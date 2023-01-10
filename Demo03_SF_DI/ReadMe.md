在02的基础上分析DI的两种方式：setter注入、构造器注入；还涉及到自动装配和properties文件配置

① 注入方式

* setter注入：<property>

就是02中使用的，通过在依赖Bean中设置setter、成员Bean提供无参构造的方式进行DI

* constructor注入：<constructor-arg>

通过含参构造的形式注入，不需要setter方法

② 自动装配：autowire

IoC容器根据Bean所依赖的资源在容器中自动查找并注入到Bean的过程称为自动装配

自动装配仅适用引用类型（Bean），不适用基本类型（包括String）

自动装配应用反射机制，不需要使用getter、setter。

* 自动装配方式：byName, byType, constructor, default, no

* **注意**
    * 自动装配机制必须提供**无参构造**
    * 自动装配会扫描依赖Bean中声明的成员Bean并依照选定的规则进行装配（byType, byName等）

③ 集合注入：<property>, <constructor>

如上述，自动装配不适用普通类型注入，但是property和constructor均可：

提供不同子标签完成注入：<array>, <list>, <set>, <map>, <props>

注意：setter方法名比较固定：setArray, setList, setSet, setMap, setProperties（properties也属于java集合类，不要和properties文件搞混）

④ properties文件

在文件中配置相应参数，并以EL表达式的形式在applicationContext中进行引用赋值，注意在xml文件中声明使用properties文件（context）

* property-placeholder：声明properties文件所在位置

  `<context:property-placeholder location="config.properties"/>`：config.properties是本次使用的properties文件

    * properties标签属性
        * 加载多个properties文件
          `<context:~ location="config.properties"/>`
        * 加载所有的properties文件
          `<context:~ location="classpath:*.properties"/>`
        * 引入其他jar包时，读取所有properties文件
          `<context:~ location="classpath*:*.properties"/>`
        * 不加载系统属性，如$path之类的
          `<context:~ location=~ system-properties-mode="NEVER"/>`