package fromwsdl.client;

public class AddNumbersClient {

    public static void main(String[] args) {
        AddNumbersPortType port = new AddNumbersService().getAddNumbersPort();

        int number1 = 10;
        int number2 = 20;

        System.out.println("##############################################");
        System.out.println("### JAX-WS Webservices examples - fromwsdl ###");
        System.out.println("##############################################");
        System.out.println("Testing Java class webservices from WSDL...");
        int result = port.addNumbers(number1, number2);
        if (result == 30) {
            System.out.println("Success!");
        }
    }
}
