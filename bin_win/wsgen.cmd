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
SET CLASS_PATH=%JAVA_HOME%\lib\tools.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\javaee.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\jaxws-tools.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\jeus.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\jeus-ws.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\jeusapi.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\jeusjaxb.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\jeusutil.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\xalan.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\xercesImpl.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\xml_resource.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\xml-apis.jar
SET CLASS_PATH=%CLASS_PATH%;%JEUS_HOME%\lib\system\xsltc.jar

REM execute wsgen
"%JAVA_HOME%\bin\java" -classpath "%CLASS_PATH%" %TOOL_OPTION% ^
    -Djava.endorsed.dirs="%JEUS_HOME%\lib\endorsed" ^
    %WSGEN_OPTS% ^
    %JAVA_ARGS% ^
    jeus.webservices.jaxws.tools.WsGen %BOOT_PARAMETER%

ENDLOCAL
