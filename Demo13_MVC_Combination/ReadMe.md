这个模块依旧没有code

**SSM整合**

(1) Spring

* SpringConfig
* MyBatis
    * MybatisConfig
* JdbcConfig
    * jdbc.properties

(2) SpringMVC

* ServletConfig
* SpringMvcConfig

(3) 表与实体类

(4) dao（接口+自动代理-autowire+mapper类）

(5) service（接口+实现类）

* 业务层接口测试（整合JUnit）

(6) controller

* 表现层接口测试（PostMan）

**响应数据封装**

如之前展示的：SpringMVC可以返回实体类，因此，这里定义一个Result实体类作为统一的返回格式，

一般定义：① Object data作为返回结果（如get请求）；② int code：响应状态码；② String msg：响应消息提示信息