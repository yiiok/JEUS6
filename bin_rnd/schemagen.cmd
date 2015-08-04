@echo off
SETLOCAL

CALL jeus.properties.cmd

IF ERRORLEVEL == 3 EXIT /B

"%JAVA_HOME%\bin\java" -classpath %JEUS_HOME%\lib\system\jaxb-xjc.jar;%JEUS_HOME%\lib\system\javaee.jar;%JEUS_HOME%\lib\system\activation.jar %TOOL_OPTION% com.sun.tools.jxc.SchemaGeneratorFacade %*

ENDLOCAL
