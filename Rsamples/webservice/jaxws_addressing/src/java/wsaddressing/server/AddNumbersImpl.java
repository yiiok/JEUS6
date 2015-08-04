package wsaddressing.server;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.Action;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.soap.Addressing;

@Addressing
@WebService
public class AddNumbersImpl {

    @Resource
    WebServiceContext wsc;

    @Action(input = "http://tmaxsoft.com/input", output = "http://tmaxsoft.com/output")
    public int addNumbers(int number1, int number2) {
        return number1 + number2;
    }

    public int addNumbers2(int number1, int number2) {
        return number1 + number2;
    }
}
