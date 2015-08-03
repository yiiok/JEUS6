@echo off

call jeus.properties.bat

"%JAVA_HOME%\bin\java" %JAVA_ARGS% ^
    -classpath "%JEUS_HOME%\lib\system\bootstrap.jar" ^
    -Djeus.home="%JEUS_HOME%" ^
    -Djeus.ejb.compiler.mode=batch ^
    -Djava.endorsed.dirs="%JEUS_ENDORSED%" ^
    jeus.tool.compiler.AppCompilerBootstrapper %*
