@echo off

SETLOCAL

REM set JEUS_HOME if not specified
set FileDir=%~dp0
if "%JEUS_HOME%" == "" ^
set JEUS_HOME=%FileDir:~0,-5%

REM set JEUS properties
CALL %JEUS_HOME%\bin\jeus.properties.cmd
set WEBTOBDIR=%JEUS_WSDIR%
"%JEUS_WSDIR%\bin\CA.cmd" %*

ENDLOCAL
