@echo off
setlocal

set JAF_LIBS=%JEUS_HOME%\lib\system\activation.jar;%JEUS_HOME%\lib\system\mail.jar
set WSRM_LIBS=%JEUS_HOME%\lib\system\wsaddr.jar;%JEUS_HOME%\lib\system\wsrm.jar
set LIBS=%JEUS_HOME%\lib\system\jeus.jar;%JAF_LIBS%;%WSRM_LIBS%
set RUNNER=jeus.webservices.ws.rm.storage.tool.RMStorageTool

java -classpath %LIBS% -Djeus.home=%JEUS_HOME% %RUNNER% %*

endlocal
