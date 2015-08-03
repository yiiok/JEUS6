@echo off
SETLOCAL

REM set JEUS_HOME if not specified
set FileDir=%~dp0
if "%JEUS_HOME%" == "" ^
set JEUS_HOME=%FileDir:~0,-5%

REM set JEUS properties
CALL %JEUS_HOME%\bin\jeus.properties.cmd

IF ERRORLEVEL == 3 EXIT /B

IF DEFINED USERNAME (
	SET BOOT_PARAMETER=-U%USERNAME% -P%PASSWORD% %*
) ELSE (
	SET BOOT_PARAMETER=%*
)

REM if the option "-h" is set just print out the help message without starting process
SET BOOT_PARAMETER_HELP_REMOVED=%BOOT_PARAMETER:-h=%
IF DEFINED BOOT_PARAMETER (
IF NOT "%BOOT_PARAMETER%"=="%BOOT_PARAMETER_HELP_REMOVED%" (
ECHO.
ECHO jeus  start JEUS Server
ECHO.
ECHO Usage:
ECHO      jeus [-h] [-protectkey] [-d] [-xml] [-U^<username^>] [-P^<password^>]
ECHO           [-f^<filename^>] [-D^<property=value^>] [-properties=^<filename^>]
ECHO.
ECHO      arguments:
ECHO        -h: show this help page
ECHO        -protectkey: use protected secret key
ECHO        -d: boot dynamic mode
ECHO        -xml: use XML ^(deprecated^)
ECHO        -U^<username^>: set username
ECHO        -P^<password^>: set password
ECHO        -f^<filename^>: set filename of username and password
ECHO        -D^<property=value^>: set system property. This option can be used more
ECHO                            than once.
ECHO        -properties=^<filename^>: set system properties from the specified
ECHO                                system property file.

EXIT /B
)
)

REM echo environment
ECHO **************************************************************
ECHO   - JEUS Home         : %JEUS_HOME%
ECHO   - JEUS Base Port    : %JEUS_BASEPORT%
ECHO   - Added Java Option : %JAVA_ARGS%
ECHO   - Java Vendor       : %JAVA_VENDOR%
ECHO **************************************************************

REM execute jeus with echo
@echo on
"%JAVA_HOME%\bin\java" %VM_OPTION% %SESSION_MEM% ^
-Xbootclasspath/p:"%JEUS_HOME%\lib\system\extension.jar" ^
-classpath "%JEUS_HOME%\lib\system\bootstrap.jar" ^
-Dsun.rmi.dgc.client.gcInterval=3600000 ^
-Dsun.rmi.dgc.server.gcInterval=3600000 ^
-Djeus.jvm.version=%VM_TYPE% ^
-Djeus.home="%JEUS_HOME%" ^
-Djeus.log.home="%JEUS_HOME%\logs" ^
-Djava.naming.factory.initial=jeus.jndi.JNSContextFactory ^
-Djava.naming.factory.url.pkgs=jeus.jndi.jns.url ^
-Djava.library.path="%JEUS_LIBPATH%" ^
-Djeus.baseport=%JEUS_BASEPORT% ^
-Djava.endorsed.dirs="%JEUS_HOME%\lib\endorsed" ^
-Djava.util.logging.manager=jeus.util.logging.JeusLogManager ^
-Djava.util.logging.config.file="%JEUS_HOME%\bin\logging.properties" ^
-Djeus.properties.replicate=jeus,java.util.logging,sun.rmi.dgc ^
-Djeus.tool.webadmin.locale.language=%JEUS_LANG% ^
-Djava.net.preferIPv4Stack=true ^
%JAVA_ARGS% ^
jeus.server.JeusBootstrapper %BOOT_PARAMETER%
@echo off

ENDLOCAL
