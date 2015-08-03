package fastinfoset.client;

import javax.xml.ws.BindingProvider;

import com.sun.xml.ws.client.ContentNegotiation;

public class AddNumbersClient {

    public static void main(String[] args) {
        AddNumbersImpl port = new AddNumbersImplService()
                .getAddNumbersImplPort();
        ((BindingProvider) port).getRequestContext().put(
                ContentNegotiation.PROPERTY, "pessimistic");

        int number1 = 10;
        int number2 = 20;

        System.out.println("#################################################");
        System.out.println("### JAX-WS Webservices examples - fastinfoset ###");
        System.out.println("#################################################");
        System.out.println("Testing Fast Infoset webservices...");
        int result = port.addNumbers(number1, number2);
        if (result == 30) {
            System.out.println("Success!");
        }
    }
}
