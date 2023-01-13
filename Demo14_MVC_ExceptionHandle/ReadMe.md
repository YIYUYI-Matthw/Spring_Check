承接：返回数据封装（Resule）

(1) 当各种异常出现时：统一throws然后到表现层一并处理，则异常最终可被分为三类：

* 业务异常（BusinessException）

  规范的用户行为产生的异常
* 不规范的用户行为操作产生的异常

  系统异常（SystemException）

  项目运行过程中可预计且无法避免的异常
* 其他异常（Exception）

  编程人员未预期到的异常，如断网了

(2) 处理方案

对于所有抛出的异常，最终返回形式都是Result封装数据类型，其中状态码及msg信息提示用户异常状态、异常原因

要做到这一点：拿到抛出的异常，对异常返回数据做增强后再返回：AOP思想。

但和Spring AOP并不一样，这里的增强是针对异常类对象的，Spring AOP是针对方法动作的：

* 自定义两种类型的异常：`BusinessException`和`SystemException`

  这两种异常类内封装异常状态码和用户提示信息
* 利用`@RestControllerAdvice`修饰异常处理增强类：
* 通过`@ExceptionHandler(Exception.class)`指定处理的异常类型，并返回Result（code为异常状态码）。