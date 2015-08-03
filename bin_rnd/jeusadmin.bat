@echo off

call jeus.properties.bat

"%JAVA_HOME%\bin\java" %JAVA_ARGS% ^
    -classpath "%JEUS_HOME%\lib\system\bootstrap.jar" ^
    -Djeus.home="%JEUS_HOME%" ^
    -Djava.endorsed.dirs="%JEUS_ENDORSED%" ^
    -Djava.library.path="%JEUS_LIBPATH%" ^
    -Djava.naming.factory.initial=jeus.jndi.JEUSContextFactory ^
    -Djava.naming.factory.url.pkgs=jeus.jndi.jns.url ^
    -Djeus.tm.not_use=true ^
    -Djeus.baseport=%JEUS_BASEPORT% ^
    jeus.server.Bootstrapper jeus.server.manager.JeusCommander %*
