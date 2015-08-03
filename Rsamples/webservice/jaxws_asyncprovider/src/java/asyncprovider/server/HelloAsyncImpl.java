package asyncprovider.server;

import com.sun.xml.ws.api.server.AsyncProvider;
import com.sun.xml.ws.api.server.AsyncProviderCallback;

import javax.xml.bind.JAXBContext;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceProvider;

import org.w3c.dom.Node;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@WebServiceProvider(wsdlLocation = "WEB-INF/wsdl/hello.wsdl", targetNamespace = "http://tmaxsoft.com", serviceName = "Hello", portName = "HelloAsyncPort")
public class HelloAsyncImpl implements AsyncProvider<Source> {

    public void invoke(Source source, AsyncProviderCallback<Source> callback,
            WebServiceContext ctxt) {
        try {
            DOMResult dom = new DOMResult();
            Transformer trans = TransformerFactory.newInstance()
                    .newTransformer();
            trans.transform(source, dom);

            Node node = dom.getNode().getFirstChild().getFirstChild()
                    .getFirstChild();
            String str = node.getNodeValue();
            new Thread(new RequestHandler(callback, str)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class RequestHandler implements Runnable {

        final AsyncProviderCallback<Source> callback;

        final String hello;

        public RequestHandler(AsyncProviderCallback<Source> callback,
                String hello) {
            this.callback = callback;
            this.hello = hello;
        }

        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                return;
            }
            try {
                String body = "<helloResponse xmlns=\"http://tmaxsoft.com\"><return>"
                        + hello + "</return></helloResponse>";
                callback.send(new StreamSource(new ByteArrayInputStream(body
                        .getBytes())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
