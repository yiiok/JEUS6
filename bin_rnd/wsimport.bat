@echo off
java %WSIMPORT_OPTS% -cp "%JAVA_HOME%\lib\tools.jar;%JEUS_HOME%\lib\system\jaxws-tools.jar;%JEUS_HOME%\lib\system\javaee.jar" com.sun.tools.ws.WsImport %*
