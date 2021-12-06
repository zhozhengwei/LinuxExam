#!bin/bash
javacfile(){
 echo "__________开始编译___________"
 javac -d . Notepad.java
 javac -d . /root/servletTest/Notepad.java NoteDao.java
 javac -classpath /root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/c3p0-0.9.5.2.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/mchange-commons-java-0.2.12.jar -d . C3P0util.java
 javac -classpath /root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/c3p0-0.9.5.2.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/mchange-commons-java-0.2.12.jar -d . /root/servletTest/Notepad.java /root/servletTest/C3P0util.java /root/servletTest/NoteDao.java NoteImplement.java
 javac -classpath /root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/jedis-2.9.0.jar -d . JedisUtil.java
 javac -classpath /root/apache-tomcat-8.5.72/lib/servlet-api.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/gson-2.8.2.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/jedis-2.9.0.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/commons-io-2.4.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/c3p0-0.9.5.2.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/mchange-commons-java-0.2.12.jar -d . /root/servletTest/Notepad.java /root/servletTest/JedisUtil.java /root/servletTest/NoteImplement.java /root/servletTest/Notepad.java /root/servletTest/C3P0util.java /root/servletTest/NoteDao.java AddServlet.java
 javac -classpath /root/apache-tomcat-8.5.72/lib/servlet-api.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/gson-2.8.2.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/jedis-2.9.0.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/commons-io-2.4.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/c3p0-0.9.5.2.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/mchange-commons-java-0.2.12.jar -d . /root/servletTest/Notepad.java /root/servletTest/JedisUtil.java /root/servletTest/NoteImplement.java /root/servletTest/Notepad.java /root/servletTest/C3P0util.java /root/servletTest/NoteDao.java DeleteServlet.java
 javac -classpath /root/apache-tomcat-8.5.72/lib/servlet-api.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/gson-2.8.2.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/jedis-2.9.0.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/commons-io-2.4.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/c3p0-0.9.5.2.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/mchange-commons-java-0.2.12.jar -d . /root/servletTest/Notepad.java /root/servletTest/JedisUtil.java /root/servletTest/NoteImplement.java /root/servletTest/Notepad.java /root/servletTest/C3P0util.java /root/servletTest/NoteDao.java SelectServlet.java
 javac -classpath /root/apache-tomcat-8.5.72/lib/servlet-api.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/gson-2.8.2.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/jedis-2.9.0.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/commons-io-2.4.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/c3p0-0.9.5.2.jar:/root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/lib/mchange-commons-java-0.2.12.jar -d . /root/servletTest/Notepad.java /root/servletTest/JedisUtil.java /root/servletTest/NoteImplement.java /root/servletTest/Notepad.java /root/servletTest/C3P0util.java /root/servletTest/NoteDao.java UpdateServlet.java
}

decide(){
 if [ $? -eq 0 ];then
     echo "可以进行复制项目编译文件"
 else
     echo "编译报错"
 fi
}

install_tomcat(){
 echo"开始复制"
 cp -r /root/servletTest/cn /root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/classes/
 cp c3p0-config.xml /root/apache-tomcat-8.5.72/webapps/ROOT/WEB-INF/classes/
}

stoptomcat(){
 echo "停止tomcat"
 /root/apache-tomcat-8.5.72/bin/./shutdown.sh
}

starttomcat(){
 echo "启动tomcat"
 /root/apache-tomcat-8.5.72/bin/./startup.sh
}

main(){
 ((javacfile && decide && install_tomcat && stoptomcat && starttomcat) >> /root/servletTest/installLog.txt) && ok
 echo "运行日志installLog.txt"
}

main