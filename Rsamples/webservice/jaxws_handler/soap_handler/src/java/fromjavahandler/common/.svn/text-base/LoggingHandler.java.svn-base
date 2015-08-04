package fromjavahandler.common;

import java.io.PrintStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class LoggingHandler implements SOAPHandler<SOAPMessageContext> {

    public Set<QName> getHeaders() {
        return null;
    }

    public void close(MessageContext messageContext) {

    }

    public boolean handleFault(SOAPMessageContext smc) {
        return true;
    }

    public boolean handleMessage(SOAPMessageContext smc) {
        Boolean inboundProperty = (Boolean) smc
                .get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        System.out.println("\n###################################################");
        System.out.println("### JAX-WS Webservices examples - soap handler  ###");
        System.out.println("###################################################");

        if (inboundProperty.booleanValue()) {
            System.out.println("\nClient message:");
        } else {
            System.out.println("\nServer message:");
        }

        SOAPMessage message = smc.getMessage();
        try {
            message.writeTo(System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
