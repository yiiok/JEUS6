@echo off

call jeus.properties.bat

if "%JEUS_USERNAME%" NEQ "" ^
set APPCLIENT_SECURITY_ARGS=^
    -Djava.naming.security.principal=%JEUS_USERNAME% ^
    -Djava.naming.security.credentials=%JEUS_USERPASSWORD%

"%JAVA_HOME%\bin\java" %JAVA_ARGS% ^
    -classpath "%JEUS_HOME%\lib\client\clientcontainer.jar" ^
    -Djava.endorsed.dirs="%JEUS_HOME%\lib\endorsed" ^
    -Djava.util.logging.config.file=logging.properties ^
    -Djava.naming.factory.initial=jeus.jndi.JNSContextFactory ^
    -Djava.naming.factory.url.pkgs=jeus.jndi.jns.url ^
    -Djava.naming.provider.url=%JEUS_HOSTNAME% ^
    -Djeus.baseport=%JEUS_BASEPORT% ^
    %APPCLIENT_SECURITY_ARGS% ^
    jeus.client.container.ClientContainer %*
