@echo off
set PATH=%JAVA_HOME%\bin;%PATH%
set SERVLET_HOME=%JEUS_HOME%\webhome\servlet_home
set EJB_HOME=%JEUS_HOME%\webhome\ejb_home
set CLIENT_HOME=%JEUS_HOME%\webhome\client_home
set JEUS_BASEPORT=9736
java -classpath "%JEUS_HOME%\lib\system\bootstrap.jar" -Djeus.home=%JEUS_HOME% -Djeus.baseport=%JEUS_BASEPORT% -Djava.naming.factory.initial=jeus.jndi.JEUSContextFactory -Djava.naming.factory.url.pkgs=jeus.jndi.jns.url -Djava.library.path=%JEUS_HOME%\lib\system -Djeus.security.globalPassword=syspass jeus.server.Bootstrapper jeus.security.admin.SecurityAdminConsole %*
 