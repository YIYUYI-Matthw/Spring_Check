这个模块中没有具体代码，而是知识点的集合

请求/相应涉及三个部分：

* 请求

  指的是请求路径、请求类型。

    * 在mvc的controller中，不通过方法区分请求类型；
    * 对于请求路径，不同controller可能都有/save，为了区分，需要在controller类添加类注解prefix`@RequestMapping("/user")`


* 请求参数

  （1）请求参数分为：① get请求参数（url?a=1）；② post请求提交表单；③ post请求提交json（js对象类型）；

  （2）接收到请求参数后，mvc会有两种操作：① 直接赋值；② 将参数封装为类对象（如参数为name、age，而接收后转化为User）。

    * get请求参数

      直接写入即可：
      ```java
      // url?name=123
      @RequestMapping("/Type")
      class TypeController{
        @RequestMapping("/xx")
        public String method(String name){
            return "收到了";
        }
      }
      ```
      如果get请求发送的参数名和形参不一致，使用`@RequestParam`来纠正：
      ```java
      // url?name=123
      @RequestMapping("/Type")
      class TypeController{
        @RequestMapping("/xx")
        public String method(@RequestParam("name") String userName){
            return "收到了";
        }
      }
      ```
      参数转为类对象：形参为对应的类
        ```java
      // url?name=123&age=22
      
      class User{
            Sring name;
            Integer age;
      }
      
      @RequestMapping("/Type")
      class TypeController{
            @RequestMapping("/xx")
            public String method(User user){
                return "收到了";
            }
      }
      ```
      参数为数组：同上：直接接收

      参数为集合类型：增加注解 @RequestParam 标明直接赋值而非根据参数创建引用类型参数的对象
    * post提交表单：同get
    * post提交json

        1. 首先在mvc中增加对json数据的支持

      ① pom中添加 jackson-databind 坐标（不能用fastJson：无法转换POJO类）

      ② 在MVCConfig.java中增加 @EnableWebMvc 支持json数据转化

        2. 形参前增加@RequestBody注解：**接收**json数据【application/json】

（3）响应

* 返回String

  `return "xxx";` // 即使xx=`"{'a':'b'}"`也是返回String：本来就不符合json格式：key要使用双引号
* 返回json

  在接收json数据配置的基础上增加`json-core`依赖

  `return pojo;` // spring会将实体类转为json返回