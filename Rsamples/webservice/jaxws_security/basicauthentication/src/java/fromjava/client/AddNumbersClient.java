package fromjava.client;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class AddNumbersClient {

    public static void main(String[] args) {
        AddNumbersClient client = new AddNumbersClient();
        client.execute();
    }
    
    public void execute() {
        Authenticator.setDefault(new MyAuthenticator());
        
        AddNumbersImpl port = new AddNumbersImplService()
                .getAddNumbersImplPort();
        ((javax.xml.ws.BindingProvider) port).getRequestContext().put(javax.xml.ws.BindingProvider.USERNAME_PROPERTY, "jeus");
        ((javax.xml.ws.BindingProvider) port).getRequestContext().put(javax.xml.ws.BindingProvider.PASSWORD_PROPERTY, "jeus");

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
    
    class MyAuthenticator extends Authenticator {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("jeus", "jeus".toCharArray());
        }
    }
}
