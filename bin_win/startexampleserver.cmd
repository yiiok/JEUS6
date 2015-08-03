@ECHO OFF
SETLOCAL

REM set JEUS_HOME if not specified
set FileDir=%~dp0
if "%JEUS_HOME%" == "" ^
set JEUS_HOME=%FileDir:~0,-5%

REM set JEUS properties
CALL %JEUS_HOME%\bin\jeus-example.properties.cmd

IF ERRORLEVEL == 3 EXIT /B

ECHO **************************************************************
ECHO                JEUS EXAMPLE SERVER
ECHO OFF
ECHO   - JEUS Home         : %JEUS_HOME%
ECHO   - JEUS Base Port    : %JEUS_BASEPORT%
ECHO   - Java Vendor       : %JAVA_VENDOR%
ECHO   - Added Java Option : %JAVA_ARGS%
ECHO **************************************************************

IF DEFINED USERNAME (
	SET BOOT_PARAMETER=-U%USERNAME% -P%PASSWORD%
) ELSE (
	SET BOOT_PARAMETER=%*
)

start startderby

echo "%JAVA_HOME%\bin\java" %VM_OPTION% %SESSION_MEM% -Xbootclasspath/p:"%JEUS_HOME%\lib\system\extension.jar";"%JEUS_HOME%\lib\system\classloader.jar" -classpath "%JEUS_HOME%\lib\system\bootstrap.jar" -Djeus.jvm.version=%VM_TYPE% -Djava.endorsed.dirs="%JEUS_HOME%\lib\endorsed" -Djeus.home="%JEUS_HOME%" -Djava.naming.factory.initial=jeus.jndi.JNSContextFactory -Djava.naming.factory.url.pkgs=jeus.jndi.jns.url -Djava.library.path=%JEUS_LIBPATH% -Djeus.session.version=%SESSION_VERSION% -Djeus.baseport=%JEUS_BASEPORT% -Djeus.tm.checkReg=true -Djava.util.logging.config.file="%JEUS_HOME%\bin\logging.properties" -Djava.net.preferIPv4Stack=true -Djeus.tool.webadmin.locale.language=%JEUS_LANG% %JAVA_ARGS% jeus.server.JeusBootstrapper %BOOT_PARAMETER%

"%JAVA_HOME%\bin\java" %VM_OPTION% %SESSION_MEM% -Xbootclasspath/p:"%JEUS_HOME%\lib\system\extension.jar";"%JEUS_HOME%\lib\system\classloader.jar" -classpath "%JEUS_HOME%\lib\system\bootstrap.jar" -Djeus.jvm.version=%VM_TYPE% -Djeus.home="%JEUS_HOME%" -Djava.endorsed.dirs="%JEUS_HOME%\lib\endorsed" -Djava.naming.factory.initial=jeus.jndi.JNSContextFactory -Djava.naming.factory.url.pkgs=jeus.jndi.jns.url -Djava.library.path=%JEUS_LIBPATH% -Djeus.session.version=%SESSION_VERSION% -Djeus.baseport=%JEUS_BASEPORT% -Djeus.tm.checkReg=true -Djava.util.logging.config.file="%JEUS_HOME%\bin\logging.properties" -Djava.net.preferIPv4Stack=true -Djeus.tool.webadmin.locale.language=%JEUS_LANG% %JAVA_ARGS% jeus.server.JeusBootstrapper %BOOT_PARAMETER%

stopderby

ENDLOCAL
