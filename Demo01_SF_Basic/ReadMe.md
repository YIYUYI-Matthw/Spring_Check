在00的基础上增加spring-framework：

① 创建applicationContext.xml充当配置IoC容器的文件：

* Bean

  配置Service的Bean：class为ServiceImpl
  配置Dao的Bean：class为DaoImpl

* DI

  配置Service依赖Dao【Bean】
  在Service中增加setDao方法以供IoC容器调用:要求成员Bean提供无参构造方法;依赖Bean提供setDao方法

② 读取applicationContext.xml配置生成IoC容器实例context

通过context.getBean获取Service，利用多态性质，将ServiceImpl-Bean返回给Service

⭐使用到的Bean属性:

* id:标记Bean:提供给其他Bean注入依赖; IoC容器获取Bean的依据
* class:标明是哪个类被封装为Bean
* property:Bean容器属性配置,这里用于依赖注入:配置成员Bean
    * name:类定义中的成员Bean的实例名
    * ref:成员Bean由哪个类实例化(注入哪个Bean)