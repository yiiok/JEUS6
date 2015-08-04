@echo off
SETLOCAL

REM set JEUS_HOME if not specified
set FileDir=%~dp0
if "%JEUS_HOME%" == "" ^
set JEUS_HOME=%FileDir:~0,-5%

REM set JEUS properties
CALL %JEUS_HOME%\bin\jeus.properties.cmd

IF ERRORLEVEL == 3 EXIT /B

REM set boot parameter
SET BOOT_PARAMETER=%*

REM set classpath
SET CLASS_PATH=%JEUS_HOME%\lib\system\jeus.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\jeusapi.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\javaee.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\jeusutil.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\jeusjaxb.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\xmlsec.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\tmaxjce_jdk15x.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\jeus-ws.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\jaxb-impl.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\jaxb-xjc.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\jaxws-rt.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\jaxws-tools.jar

REM set wsdl2uddi options
SET WSDL2UDDI_OPTS=

REM execute wsdl2uddi
"%JAVA_HOME%\bin\java" -classpath "%CLASS_PATH%" %TOOL_OPTION% ^
    -Djava.endorsed.dirs="%JEUS_HOME%\lib\endorsed" ^
    %WSDL2UDDI_OPTS% ^
    %JAVA_ARGS% ^
    jeus.server.Bootstrapper jeus.webservices.tools.wsdl2uddi.Wsdl2Uddi %BOOT_PARAMETER%

ENDLOCAL
