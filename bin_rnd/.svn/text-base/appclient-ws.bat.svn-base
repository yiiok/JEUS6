@echo off

:::::::::::::::::::::::::::::::::::::::::::::::::::
:: Please do not modify this script.
:: Insteand you can handle jeus.properties script.
:::::::::::::::::::::::::::::::::::::::::::::::::::

call jeus.properties.bat

if "%JEUS_USERNAME%" NEQ "" ^
set APPCLIENT_SECURITY_ARGS=^
    -Djava.naming.security.principal=%JEUS_USERNAME% ^
    -Djava.naming.security.credentials=%JEUS_USERPASSWORD%

"%JAVA_HOME%\bin\java" %JAVA_ARGS% ^
    -classpath "%JEUS_HOME%\lib\client\clientcontainer.jar;%JEUS_HOME%\lib\system\jeus-ws.jar;%JEUS_HOME%\lib\system\activation.jar;%JEUS_HOME%\lib\system\mail.jar;%JEUS_HOME%\lib\system\jaxb-impl.jar;%JEUS_HOME%\lib\system\saaj-impl.jar;%JEUS_HOME%\lib\system\jaxws-rt.jar;%JEUS_HOME%\lib\system\sjsxp.jar;%JEUS_HOME%\lib\system\streambuffer.jar;%JEUS_HOME%\lib\system\stax-ex.jar;%JEUS_HOME%\lib\system\resolver.jar;%JEUS_HOME%\lib\system\FastInfoset.jar;%JEUS_HOME%\lib\system\wsit.jar" ^
    -Djava.endorsed.dirs="%JEUS_HOME%\lib\endorsed" ^
    -Djava.util.logging.config.file=logging.properties ^
    -Djava.naming.factory.initial=jeus.jndi.JNSContextFactory ^
    -Djava.naming.factory.url.pkgs=jeus.jndi.jns.url ^
    -Djava.naming.provider.url=%JEUS_HOSTNAME% ^
    -Djeus.baseport=%JEUS_BASEPORT% ^
    %APPCLIENT_SECURITY_ARGS% ^
    jeus.client.container.ClientContainer %*
