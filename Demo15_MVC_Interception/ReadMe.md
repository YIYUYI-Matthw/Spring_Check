拦截器 v.s. Filter

* 拦截器（Interceptor）是一种动态拦截方法调用的机制，在SpringMVC中动态拦截控**制器方法**的执行
* Filter对所有访问进行增强，Interceptor仅针对SpringMVC的访问进行增强（在servletInit中设置过MVC访问路径）

## 使用

* 定义一个拦截器Bean：要继承`HandleInterceptor`

  在里面定义拦截时机、动作：`preHandle`、`postHandle`、`afterCompletion`三个方法及其方法体
    * 为指定路径添加拦截器

      在init-11模块中有提到`WebMvcConfigurationSupport`这么个类，当时定义其实现类用于配置Filter（处理了乱码问题）。

      在其实现类中装配拦截器Bean并重载addInterceptor方法：

        ```java
      @Override 
      public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(projectInterceptor)
                    .addPathPatterns("/books"); }
      ```


* 拦截与继续

  对于preHandle：其返回值为boolean：true-继续；false-终止-用户不会收到任何返回值，效果和没有发送请求一样

* 拦截器可以组成拦截器链：registry.add.add.add...