package fromjava.client;

public class AddNumbersClient {

    public static void main(String[] args) {
        AddNumbersImpl port = new AddNumbersImplService()
                .getAddNumbersImplPort();
        // ((javax.xml.ws.BindingProvider) port).getRequestContext().put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:9999/DocLitEchoService/AddNumbersImplService");

        int number1 = 10;
        int number2 = 20;

        System.out.println("##############################################");
        System.out.println("### JAX-WS Webservices examples - fromjava ###");
        System.out.println("##############################################");
        System.out.println("Testing Java class webservices...");
        int result = port.addNumbers(number1, number2);
        if (result == 30) {
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }
    }
}