@echo off

call jeus.properties.bat

"%JAVA_HOME%\bin\java" %JAVA_ARGS% ^
    -classpath "%JEUS_HOME%\lib\system\bootstrap.jar" ^
    -Djava.library.path="%JEUS_LIBPATH%" ^
    -Djeus.home="%JEUS_HOME%" ^
    -Dos.name=Windows ^
    jeus.server.Bootstrapper ^
    jeus.security.util.EncryptionTool %*
