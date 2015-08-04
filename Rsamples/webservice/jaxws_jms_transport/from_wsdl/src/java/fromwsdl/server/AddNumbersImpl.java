package fromwsdl.server;

@javax.jws.WebService(endpointInterface = "fromwsdl.server.AddNumbersPortType", wsdlLocation = "WEB-INF/wsdl/AddNumbers.wsdl", targetNamespace = "urn:AddNumbers", serviceName = "AddNumbersService", portName = "AddNumbersPort")
@jeus.webservices.jaxws.api.JMSWebService(connectionFactory = "QueueConnectionFactory", 
                                          destination = "ExamplesQueue", 
                                          portName = "AddNumbersJMSPort")
public class AddNumbersImpl {

    public int addNumbers(int number1, int number2) {
        return number1 + number2;
    }
}
