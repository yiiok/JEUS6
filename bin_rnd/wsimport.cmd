@echo off
SETLOCAL

CALL jeus.properties.cmd

IF ERRORLEVEL == 3 EXIT /B

"%JAVA_HOME%\bin\java" %WSIMPORT_OPTS% %TOOL_OPTION% -classpath "%JAVA_HOME%\lib\tools.jar;%JEUS_HOME%\lib\system\javaee.jar;%JEUS_HOME%\lib\system\jaxws-tools.jar;%JEUS_HOME%\lib\system\jeus.jar;%JEUS_HOME%\lib\system\jeus-ws.jar;%JEUS_HOME%\lib\system\jeusapi.jar;%JEUS_HOME%\lib\system\jeusjaxb.jar;%JEUS_HOME%\lib\system\jeusutil.jar;%JEUS_HOME%\lib\system\xml_resource.jar" jeus.webservices.jaxws.tools.WsImport %*

ENDLOCAL
