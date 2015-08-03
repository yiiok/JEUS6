package swaref.server;

import javax.activation.DataHandler;
import javax.jws.WebService;

@WebService(endpointInterface = "swaref.server.Hello", wsdlLocation = "WEB-INF/wsdl/hello.wsdl", targetNamespace = "http://tmaxsoft.com/swaref", serviceName = "HelloService", portName = "HelloPort")
public class HelloImpl implements Hello {

    public DataHandler claimForm(DataHandler data) {
        return data;
    }
}
