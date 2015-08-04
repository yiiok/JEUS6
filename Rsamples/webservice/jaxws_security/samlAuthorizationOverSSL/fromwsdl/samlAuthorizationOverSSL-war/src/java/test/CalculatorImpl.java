package test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "test.Calculator", wsdlLocation = "WEB-INF/wsdl/serverwar.wsdl", targetNamespace = "http://test/", serviceName = "CalculatorService", portName = "CalculatorPort")
public class CalculatorImpl {

    public int add(int i, int j) {
        return i + j;
    }
}
