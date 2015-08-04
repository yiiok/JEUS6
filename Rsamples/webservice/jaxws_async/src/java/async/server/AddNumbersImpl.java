package async.server;

import javax.jws.WebService;

@WebService(serviceName = "AddNumbersService", targetNamespace = "http://tmaxsoft.com")
public class AddNumbersImpl {

    public int addNumbers(int number1, int number2) {
        try {
            Thread.sleep(3000);
            System.out.println("Server working heavy works.");
            Thread.sleep(3000);
            System.out.println("Server working heavy works.");
            Thread.sleep(3000);
            System.out.println("Server working heavy works.");
            Thread.sleep(3000);
        } catch (Exception e) {
            
        }
        return number1 + number2;
    }
}
