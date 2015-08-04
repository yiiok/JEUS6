@echo off
java %SCHEMAGEN_OPTS% -cp %JEUS_HOME%\lib\system\jaxb-xjc.jar;%JEUS_HOME%\lib\system\javaee.jar;%JEUS_HOME%\lib\system\activation.jar com.sun.tools.jxc.SchemaGeneratorFacade %*