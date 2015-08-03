package async.client;

import java.rmi.RemoteException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

public class AddNumbersClient {

    public static void main(String[] args) {
        try {
            AddNumbersImpl port = new AddNumbersService().getAddNumbersImplPort();

            // Asynchronous polling
            System.out.println("#############################################");
            System.out.println("### JAX-WS Webservices examples - polling ###");
            System.out.println("#############################################");
            Response<AddNumbersResponse> resp = port.addNumbersAsync(10, 20);
            System.out.println("Client should work something before response arrives.");
            Thread.sleep(5000);
            System.out.println("Client should work something before response arrives.");
            Thread.sleep(5000);
            System.out.println("Client should work something before response arrives.");
            Thread.sleep(5000);
            AddNumbersResponse output = resp.get();
            System.out.printf("result : %d\n", output.getReturn());

            // Asynchronous callback
            System.out.println("#############################################");
            System.out.println("### JAX-WS Webservices examples - callback ###");
            System.out.println("#############################################");
            AddNumbersCallbackHandler callbackHandler = new AddNumbersCallbackHandler();
            Future<?> response = port.addNumbersAsync(10, 20, callbackHandler);
            while (callbackHandler.getResponse() == null) {
                System.out.println("Client can work something until response arrives.");
                Thread.sleep(1000);
            }
            output = callbackHandler.getResponse();
            System.out.printf("result: %d\n", output.getReturn());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class AddNumbersCallbackHandler implements
            AsyncHandler<AddNumbersResponse> {

        private AddNumbersResponse output;

        public void handleResponse(Response<AddNumbersResponse> response) {
            try {
                output = response.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        AddNumbersResponse getResponse() {
            return output;
        }
    }
}
