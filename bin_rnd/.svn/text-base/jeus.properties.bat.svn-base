:: $Id$

@echo off

:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
:: The Enviroment Script For Windows                                         ::
::                                                                           ::
::                                                                           ::
:: JEUS_HOME       - The root directory of JEUS installed.                   ::
:: JEUS_BASEPORT   - The base port for JEUS.                                 ::
:: JEUS_LIBPATH    - The navtive library for JEUS.                           ::
:: JEUS_ENDORSED   - The Java endorsed mechanism libraries for JEUS.         ::
:: JEUS_HOSTNAME   - The name of host that JEUS is running                   ::
::                                                                           ::
::                                                                           ::
:: JAVA_HOME       - The Java home directory                                 ::
:: JAVA_ARGS       - The JVM Parameter(s)                                    ::
:: JAVA_VENDOR     - The JVM Vender name.                                    ::
::                                                                           ::
::                                                                           ::
::  You must set the following variables:                                    ::
::      JEUS_HOME, JEUS_BASEPORT, JAVA_HOME, JAVA_VENDOR                     ::
::                                                                           ::
::  For additional information, please refer to the JEUS Server Guide or     ::
::  visit the following web sites.                                           ::
::                                                                           ::
::  - http://www.tmaxsoft.com(English)                                       ::
::  - http://www.tmax.co.kr(Korean)                                          ::
::  - http://www.tmaxchina.com.cn(Chinese)                                   ::
::  - http://www.tmaxsoft.co.jp(Japanese)                                    ::
::  - http://technet.tmaxsoft.com(English/Korean)                            ::
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

:: set up JEUS_HOME.
if "%JEUS_HOME%" == "" ^
set JEUS_HOME=

:: set up the host name that JEUS is currently running
:: (especially for the application client)
set JEUS_HOSTNAME=localhost

:: set up JEUS_BASEPORT.
set JEUS_BASEPORT=9736

:: set up JEUS_LIBPATH.
if "%JEUS_HOME%" NEQ "" ^
set JEUS_LIBPATH=%JEUS_HOME%\lib\system

:: set up the endorsed JEUS library path.
if "%JEUS_HOME%" NEQ "" ^
set JEUS_ENDORSED=%JEUS_HOME%\lib\endorsed



:: set up the Java home directory.
if "%JAVA_HOME%" == "" ^
set JAVA_HOME=

:: setup JAVA_ARGS.
set JAVA_ARGS=

:: set up JDK vendor. Possible values are Sun, HP, IBM, etc. Default, Sun.
set JAVA_VENDOR=Sun


:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
:: This part is for booting JEUS automatically.                              ::
:: BE CAREFUL!! THIS IS ONLY FOR TEST AND DEVELOPMENT ENVIRONMENT.           ::
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

:: Set up administrator name
set USERNAME=

:: Set up administrator password
set PASSWORD=

:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
:: This part is for the authentication of appclication client or others.     ::
:: BE CAREFUL!! THIS IS ONLY FOR TEST AND DEVELOPMENT ENVIRONMENT.           ::
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

:: Set up administrator name
set JEUS_USERNAME=

:: Set up administrator password
set JEUS_USERPASSWORD=


:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
:: Check significant variables.                                              ::
:: You must set up these things.                                             ::
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

if "%JEUS_HOME%" == "" echo JEUS_HOME is not defined.
if "%JEUS_BASEPORT%" == "" echo JEUS_BASEPORT is not defined.
if "%JAVA_HOME%" == "" echo JAVA_HOME is not defined.
