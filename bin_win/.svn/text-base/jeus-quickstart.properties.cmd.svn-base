@echo off
rem ###############################################################################
rem #                                                                             #
rem # This is a property file for a JEUS example server.                          #
rem #                                                                             #
rem # Run startexampleserver script to boot JEUS example server.                  #
rem # Run stopexampleserver script to shut down JEUS example server.              #
rem #                                                                             #
rem # JEUS base port: 23000                                                       #
rem # Admin ID      : jeus                                                        #
rem # Admin password: jeus                                                        #
rem #                                                                             #
rem ###############################################################################

REM set JEUS_HOME if not specified
set FileDir=%~dp0
if "%JEUS_HOME%" == "" ^
set JEUS_HOME=%FileDir:~0,-5%

REM set JEUS properties
CALL %JEUS_HOME%\bin\jeus.properties.cmd

SET JEUS_BASEPORT=23000
SET JEUS_WSDIR=%JEUS_HOME%\webserver
SET JEUS_LIBPATH="%JEUS_HOME%\lib\system"
SET JEUS_LANG=@SW_LANG@
SET SESSION_MEM=-Xmx512m
SET JAVA_HOME=@JDKDir@
SET JAVA_ARGS=
SET JAVA_VENDOR=Sun

rem
rem This part is for booting JEUS automatically.
rem BE CAREFUL!! THIS IS ONLY FOR TEST AND DEVELOPMENT ENVIRONMENT.
rem

rem Set up administrator name
SET USERNAME=jeus

rem Set up administrator password
SET PASSWORD=jeus

TITLE TmaxSoft JEUS 6 QuickStart
