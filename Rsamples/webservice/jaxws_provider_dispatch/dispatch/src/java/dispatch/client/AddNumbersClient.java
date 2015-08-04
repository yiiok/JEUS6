package dispatch.client;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.ProtocolException;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.w3c.dom.Node;

public class AddNumbersClient {

    public static void main(String[] args) {
        try {
            Service service = Service.create(new java.net.URL("http://localhost:8088/AddNumbers/addnumbers?wsdl"), new javax.xml.namespace.QName("http://tmaxsoft.com", "AddNumbersService"));
            String request = "<addNumbers xmlns=\"http://tmaxsoft.com\"><arg0>10</arg0><arg1>20</arg1></addNumbers>";
            QName portQName = new QName("http://tmaxsoft.com", "AddNumbersPort");
            Dispatch<Source> sourceDispatch = service.createDispatch(portQName,
                    Source.class, Service.Mode.PAYLOAD);
            System.out
                    .println("##############################################");
            System.out
                    .println("### JAX-WS Webservices examples - Dispatch ###");
            System.out
                    .println("##############################################");
            System.out.println("Testing Dispatch webservices...");
            Source result = sourceDispatch.invoke(new StreamSource(
                    new StringReader(request)));
            DOMResult dom = new DOMResult();
            Transformer trans = TransformerFactory.newInstance()
                    .newTransformer();
            trans.transform(result, dom);
            Node node = dom.getNode();
            Node root = node.getFirstChild();
            Node first = root.getFirstChild();
            int sum = Integer.decode(first.getFirstChild().getNodeValue());
            if (sum == 30) {
                System.out.println("Success!");
            } else {
                System.out.println("Fail!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
