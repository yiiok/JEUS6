@echo off
SETLOCAL

REM set JEUS_HOME if not specified
set FileDir=%~dp0
if "%JEUS_HOME%" == "" ^
set JEUS_HOME=%FileDir:~0,-5%

REM set JEUS properties
CALL %JEUS_HOME%\bin\jeus-quickstart.properties.cmd

start /D"%JAVA_HOME%\bin\" javaw -classpath %TOOL_CLASSPATH%;"%JEUS_HOME%\lib\etc\quickstart.jar";"%JEUS_HOME%\lib\datasource\hsqldb.jar" %TOOL_OPTION% -Dsun.java2d.noddraw -Djeus.home="%JEUS_HOME%" -Djava.naming.factory.initial=jeus.jndi.JEUSContextFactory -Djava.naming.factory.url.pkgs=jeus.jndi.jns.url -Djeus.baseport=%JEUS_BASEPORT% com.tmax.qs.QSApp

ENDLOCAL
