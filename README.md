>#推送系统部署[Deploy twtpush platform]
>##需要环境(Environment)

###java(>=1.7)
###maven
###tomcat
###apollo
###mysql
>##部署(Deploy)

###1.编译[complie]
###2.将编译好的target文件移至%TOMCAT_HOME%/webapps下[move complied target forder to %TOMCAT_HOME%/webapps]
###3.创建broker (%APOLLO_HOME%/bin/apollo create twt)[create broker]
###4.运行broker (%APOLLO_HOME%/bin/twt/bin/apollo-broker run)[run broker]
###5.修改 (%APOLLO_HOME%/bin/twt/etc/groups.properties %APOLLO_HOME%/bin/twt/etc/users.properties) 权限 (可写)[change authority]
###6.编译运行org.twtpush.Util.Ssl包下InstallCert(javac InstallCert.java  java InstallCert <host>[:port] (例java InstallCert 127.0.0.1:60681)),后会产生证书,然后将证书move至%JAVA_HOME%/jre/lib/security/下[ssl]
