@echo off
REM set PATH=c:\jdk1.4\bin;%PATH%

call jeus.properties.bat

set SERVLET_HOME=%JEUS_HOME%\webhome\servlet_home
set EJB_HOME=%JEUS_HOME%\webhome\ejb_home
set CLIENT_HOME=%JEUS_HOME%\webhome\client_home
java -classpath "%JEUS_HOME%\lib\system\bootstrap.jar" "-Djava.library.path=%JEUS_HOME%\lib\system" -Djeus.home=%JEUS_HOME% -Djava.naming.factory.initial=jeus.jndi.JNSContextFactory -Djava.naming.factory.url.pkgs=jeus.jndi.jns.url -Djeus.servlethome=%SERVLET_HOME% jeus.server.Bootstrapper jeus.servlet.jsp.compiler.batch.BatchCompiler %*
