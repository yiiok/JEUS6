package fromjavahandler.server;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService
@HandlerChain(file = "handlers.xml")
public class AddNumbersImpl {

    public int addNumbers(int number1, int number2) {
        return number1 + number2;
    }
}
