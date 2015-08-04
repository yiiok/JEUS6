@echo off
SETLOCAL

CALL jeus.properties.cmd

IF ERRORLEVEL == 3 EXIT /B

set XJC_OPTS=
set CP="%JEUS_HOME%\lib\system\jaxb-xjc.jar;%JEUS_HOME%\lib\system\javaee.jar;%JEUS_HOME%\lib\system\activation.jar;."

"%JAVA_HOME%\bin\java" %XJC_OPTS% %TOOL_OPTION% -cp %CP% com.sun.tools.xjc.XJCFacade %*

ENDLOCAL
