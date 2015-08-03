package fromjava.server;

import javax.jws.WebService;

@WebService
public class AddNumbersImpl {

    public int addNumbers(int number1, int number2) {
        return number1 + number2;
    }

    public int addNumbers2(int number1, int number2) {
        return (number1 + number2) * 2;
    }
}
