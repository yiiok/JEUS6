@echo off

call jeus.properties.bat
cls

set JMS_CLASSPATH="%JEUS_HOME%\lib\system\bootstrap.jar"

java %JAVA_ARGS% -classpath %JMS_CLASSPATH% ^
    -Djeus.home="%JEUS_HOME%" ^
    -Djava.naming.factory.initial=jeus.jndi.JEUSContextFactory ^
    -Djava.naming.factory.url.pkgs=jeus.jndi.jns.url ^
    -Djeus.baseport=%JEUS_BASEPORT% ^
    -Djava.library.path="%JEUS_LIBPATH%" ^
    jeus.server.Bootstrapper jeus.jms.console.JMSConsole %*
