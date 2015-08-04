@echo off
REM set PATH=C:\j2sdk1.4.2_05\bin;%PATH%
set SERVLET_HOME=%JEUS_HOME%\webhome\servlet_home
set EJB_HOME=%JEUS_HOME%\webhome\ejb_home
set CLIENT_HOME=%JEUS_HOME%\webhome\client_home
set JEUS_BASEPORT=9736

java -classpath "%JEUS_HOME%\lib\system\bootstrap.jar" -Djeus.home=%JEUS_HOME% "-Djava.library.path=%JEUS_HOME%\lib\system" -Djava.naming.factory.initial=jeus.jndi.JNSContextFactory -Djava.naming.factory.url.pkgs=jeus.jndi.jns.url "-Djeus.baseport=%JEUS_BASEPORT%" jeus.server.Bootstrapper jeus.servlet.admin.WebAdmin %*
