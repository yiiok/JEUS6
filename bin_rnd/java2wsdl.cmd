@echo off
SETLOCAL

CALL jeus.properties.cmd

IF ERRORLEVEL == 3 EXIT /B

SET CP=%JEUS_HOME%\lib\system\jeus.jar;%JEUS_HOME%\lib\system\javaee.jar;%JEUS_HOME%\lib\system\jeusutil.jar;%JEUS_HOME%\lib\system\jeusjaxb.jar;%JEUS_HOME%\lib\system\xmlsec.jar;%JEUS_HOME%\lib\system\tmaxjce_jdk15x.jar;%JEUS_HOME%\lib\system\jaxb-impl.jar;%JEUS_HOME%\lib\system\jaxb-xjc.jar;%JEUS_HOME%\lib\system\jaxws-rt.jar;%JEUS_HOME%\lib\system\jaxws-tools.jar;%JEUS_HOME%\lib\system\jeus-ws.jar
"%JAVA_HOME%\bin\java" -classpath "%CP%" %JAVA2WSDL_OPTS% %TOOL_OPTION% jeus.server.Bootstrapper jeus.webservices.tools.java2wsdl.Java2Wsdl %*

ENDLOCAL
