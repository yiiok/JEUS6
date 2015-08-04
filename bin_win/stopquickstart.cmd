@echo off
SETLOCAL

REM set JEUS_HOME if not specified
set FileDir=%~dp0
if "%JEUS_HOME%" == "" ^
set JEUS_HOME=%FileDir:~0,-5%

REM set JEUS properties
CALL %JEUS_HOME%\bin\jeus-quickstart.properties.cmd

IF ERRORLEVEL == 3 EXIT /B

IF DEFINED USERNAME (
    SET BOOT_PARAMETER=-U%USERNAME% -P%PASSWORD%
) ELSE (
    ECHO Administrator ID and password is not set in jeus-quickstart.properties.cmd file.
    GOTO END	
)

"%JAVA_HOME%\bin\java" -classpath %BOOTSTRAP_CLASSPATH% %TOOL_OPTION% -Djeus.home="%JEUS_HOME%" -Djeus.config.home="%JEUS_HOME%\samples\quickstart\config"  -Djava.naming.factory.initial=jeus.jndi.JEUSContextFactory -Djava.naming.factory.url.pkgs=jeus.jndi.jns.url -Djeus.baseport=%JEUS_BASEPORT% -Djava.util.logging.config.file="%JEUS_HOME%\bin\logging.properties" %BOOTSTRAPPER%  jeus.server.manager.JeusCommander qs %BOOT_PARAMETER% jeusexit

:END

ENDLOCAL
