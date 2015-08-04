public class AddNumbersClient {

    public static void main(String[] args) {
        test.Calculator port = new test.CalculatorService().getCalculatorPort();

        int number1 = 10;
        int number2 = 20;

        System.out.println("##############################################");
        System.out.println("### JAX-WS Webservices examples - fromjava ###");
        System.out.println("##############################################");
        System.out.println("Testing Java class webservices...");
        int result = port.add(number1, number2);
        if (result == 30) {
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }
    }
}
