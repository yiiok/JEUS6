@echo off

call jeus.properties.bat

set JAVA_ARGS=-server -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005

rem %JAVA_HOME%\bin\java -server "-Xbootclasspath/p:%JEUS_HOME%\lib\system\extension.jar" -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintHeapAtGC -verbose:class -classpath "%JEUS_HOME%\lib\system\bootstrap.jar" -Djeus.jms.server.blocking=true -Djeus.home=%JEUS_HOME% -Djeus.ejb.compiler.mode=batch -Djava.library.path=%JEUS_HOME%\lib\system -Djava.naming.factory.initial=jeus.jndi.JNSContextFactory -Djava.naming.factory.url.pkgs=jeus.jndi.jns.url "-Djeus.baseport=%JEUS_BASEPORT%" -Djeus.ejb.checkTable=false -Djeus.ejb.csi.defaultUser=jeus -Djeus.ejb.enable.configDeleteOption=true -Djeus.tm.checkReg=true -Djeus.tm.forcedReg=true -Dcts.interop=true -Djeus.ejb.keepgenerated=true jeus.server.JeusBootstrapper %*

"%JAVA_HOME%\bin\java" %JAVA_ARGS% ^
    -Xbootclasspath/p:%JEUS_HOME%\lib\system\extension.jar ^
    -classpath "%JEUS_HOME%\lib\system\bootstrap.jar" ^
    -Djeus.home="%JEUS_HOME%" ^
    -Djeus.app.compiler.mode=batch ^
    -Djava.endorsed.dirs="%JEUS_ENDORSED%" ^
    -Djava.library.path="%JEUS_LIBPATH%" ^
    -Djava.naming.factory.initial=jeus.jndi.JNSContextFactory ^
    -Djava.naming.factory.url.pkgs=jeus.jndi.jns.url ^
    -Djeus.baseport=%JEUS_BASEPORT% ^
    -Djeus.ejb.checkTable=false ^
    -Djeus.ejb.csi.defaultUser=jeus ^
    -Djeus.ejb.enable.configDeleteOption=true ^
    -Djeus.tm.checkReg=true ^
    -Djeus.tm.forcedReg=true ^
    -Dcts.interop=true ^
    -Djeus.application.keepgenerated=true ^
    jeus.server.JeusBootstrapper %*
