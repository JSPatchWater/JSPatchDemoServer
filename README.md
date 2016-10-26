# JSPatchDemoServer

js热更新文件位于webapps/jspatch_api/patchfile目录下

服务端源码位于webapps/jspatch_api/src目录下

* cd到webapps/jspatch_api/src目录下
* 然后键入命令：sh compileAll.sh
* 然后重启下tomcat服务器，重启步骤如下面所示：
   * cd到tomcat的bin目录下
   * 然后键入命令：catalina debug(Mac或者Linux下输入：sh catalina.sh debug)
   * 之后再键入run(即以调试的方式启动服务器)

> 附：
> 在Mac中配置tomcat服务器教程(超详细配图)以及其配置简单原理
> [http://blog.csdn.net/smoothiemiss/article/details/51723812](http://blog.csdn.net/smoothiemiss/article/details/51723812)
