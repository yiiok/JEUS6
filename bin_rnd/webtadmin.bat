@echo off

call jeus.properties.bat

java -classpath %JEUS_HOME%\classes;%JEUS_HOME%\lib\system\jeus.jar;%JEUS_HOME%\lib\system\jeusjaxb.jar;%JEUS_HOME%\lib\system\jeusutil.jar;%JEUS_HOME%\lib\system\jxml-impl.jar;%JEUS_HOME%\lib\system\xml-apis.jar;%JEUS_HOME%\lib\system\jmxri.jar;%JEUS_HOME%\lib\system\jmxremote.jar;%JEUS_HOME%\lib\system\jmxtools.jar;%JEUS_HOME%\lib\system\jaxb-api.jar;%JEUS_HOME%\lib\system\jaxb-impl.jar;%JEUS_HOME%\lib\system\jaxb-libs.jar;%JEUS_HOME%\lib\system\relaxngDatatype.jar;%JEUS_HOME%\lib\system\xsdlib.jar;%JEUS_HOME%\lib\system\xml_resource.jar;%JEUS_HOME%\lib\system\webt50.jar;%JEUS_HOME%\lib\system\JSAP-2.0b.jar -Djeus.home=%JEUS_HOME% "-Djava.library.path=%JEUS_HOME%\lib\system" -Djava.naming.factory.initial=jeus.jndi.JNSContextFactory -Djava.naming.factory.url.pkgs=jeus.jndi.jns.url "-Djeus.baseport=%JEUS_BASEPORT%" jeus.external.tmax.WebtController %*
