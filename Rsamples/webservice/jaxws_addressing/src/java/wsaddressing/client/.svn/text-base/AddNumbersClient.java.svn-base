package wsaddressing.client;

public class AddNumbersClient {

    public static void main(String[] args) {
        try {
            int number1 = 10;
            int number2 = 10;

            AddNumbersImpl stub = new AddNumbersImplService()
                    .getAddNumbersImplPort();

            System.out
                    .println("################################################");
            System.out
                    .println("### JAX-WS Webservices examples - addressing ###");
            System.out
                    .println("################################################");
            int result = stub.addNumbers(number1, number2);
            System.out.println("basic name mapping result: " + result);

            result = stub.addNumbers2(number1, number2);
            System.out.println("default name mapping result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
