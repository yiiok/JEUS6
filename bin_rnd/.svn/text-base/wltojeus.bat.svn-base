@echo off

call jeus.properties.bat

set PATH=c:\jdk1.4\bin;%PATH%
set SERVLET_HOME=%JEUS_HOME%\webhome\servlet_home
set EJB_HOME=%JEUS_HOME%\webhome\ejb_home
set CLIENT_HOME=%JEUS_HOME%\webhome\client_home
java -Dsun.java2d.noddraw ^
    -classpath "%JEUS_HOME%\lib\system\bootstrap.jar" ^
    -Djava.library.path="%JEUS_LIBPATH%" ^
    -Djava.naming.factory.initial=jeus.jndi.JNSContextFactory ^
    -Djava.naming.factory.url.pkgs=jeus.jndi.jns.url ^
    -Djeus.jndi.jns.cachebindings=false ^
    -Djeus.home="%JEUS_HOME%" ^
    -Djeus.baseport=%JEUS_BASEPORT% ^
    jeus.server.Bootstrapper jeus.tool.converter.weblogic.WeblogicConverter %*
