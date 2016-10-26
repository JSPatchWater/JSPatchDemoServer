# JSPatchDemoServer

js热更新文件位于webapps/jspatch_api/patchfile目录下

服务端源码位于webapps/jspatch_api/src目录下

* cd到webapps/jspatch_api/src目录下
* 然后键入命令：sh compileAll.sh
* 然后重启下tomcat服务器，重启步骤如下面所示：

   * cd到tomcat的bin目录下
   * 如果tomcat服务已经启动，需要重启tomcat，请先键入命令：shutdown(Mac或者Linux下输入：sh showdown.sh) 
   * 然后键入命令：catalina debug(Mac或者Linux下输入：sh catalina.sh debug)
   * 之后再键入run(即以调试的方式启动服务器)
   
在Mac中配置tomcat服务器教程(超详细配图)以及其配置简单原理
 [http://blog.csdn.net/smoothiemiss/article/details/51723812](http://blog.csdn.net/smoothiemiss/article/details/51723812)
 
> 附：
>   * 修改 WEB-INF/classes 下的 config.properties
    * 配置热更新js文件的根路径
    * 修改 WEB-INF/classes 下的 keys.properties
    * 针对不同项目配置不同的密钥(与iOS端代码中一致)，密钥长度必须24位
