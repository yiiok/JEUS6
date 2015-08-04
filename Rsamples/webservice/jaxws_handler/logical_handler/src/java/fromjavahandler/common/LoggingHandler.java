package fromjavahandler.common;

import java.io.PrintStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;

public class LoggingHandler implements LogicalHandler<LogicalMessageContext> {

    public void close(MessageContext messageContext) {

    }

    public boolean handleFault(LogicalMessageContext lmc) {
        return true;
    }

    public boolean handleMessage(LogicalMessageContext lmc) {
        System.out.println("\n####################################################");
        System.out.println("### JAX-WS Webservices examples - logical handler  ###");
        System.out.println("####################################################");

        LogicalMessage message = lmc.getMessage();
        try {
            Source source = message.getPayload();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("indent", "yes");
            transformer.transform(source, new StreamResult(System.out));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
