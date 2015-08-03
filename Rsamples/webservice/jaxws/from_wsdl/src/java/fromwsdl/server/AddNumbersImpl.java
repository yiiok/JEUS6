package fromwsdl.server;

@javax.jws.WebService(endpointInterface = "fromwsdl.server.AddNumbersPortType", wsdlLocation = "WEB-INF/wsdl/AddNumbers.wsdl", targetNamespace = "urn:AddNumbers", serviceName = "AddNumbersService", portName = "AddNumbersPort")
public class AddNumbersImpl {

    public int addNumbers(int number1, int number2) {
        return number1 + number2;
    }
}
