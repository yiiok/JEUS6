package fromjavahandler.client;

import fromjavahandler.client.AddNumbersImpl;

public class AddNumbersClient {

    public static void main(String[] args) {
        AddNumbersImpl port = new AddNumbersImplService()
                .getAddNumbersImplPort();
        port.addNumbers(10, 20);
    }
}
