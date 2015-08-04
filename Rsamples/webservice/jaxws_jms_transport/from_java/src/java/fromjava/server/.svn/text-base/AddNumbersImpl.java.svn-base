package fromjava.server;

import javax.jws.WebService;

@WebService
@jeus.webservices.jaxws.api.JMSWebService(connectionFactory = "QueueConnectionFactory",
                                          destination = "ExamplesQueue",
                                          portName = "AddNumbersImplJMSPort")
public class AddNumbersImpl {

    public int addNumbers(int number1, int number2) {
        return number1 + number2;
    }
}
