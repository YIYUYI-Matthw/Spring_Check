这里是一个最基础的maven小项：

① 仅提供Service和Dao；

② Service中引用Dao实例，调用dao.save

③ App中通过实例化Service来调用到Service-Dao.save

pom.xml中什么也没有配置：没有用到spring