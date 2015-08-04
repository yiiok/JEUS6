package dispatch.server;

@javax.jws.WebService(endpointInterface = "dispatch.server.AddNumbersPortType", wsdlLocation = "WEB-INF/wsdl/AddNumbers.wsdl", targetNamespace = "http://tmaxsoft.com", serviceName = "AddNumbersService", portName = "AddNumbersPort")
public class AddNumbersImpl implements AddNumbersPortType {

    public int addNumbers(int number1, int number2) {
        return number1 + number2;
    }
}
