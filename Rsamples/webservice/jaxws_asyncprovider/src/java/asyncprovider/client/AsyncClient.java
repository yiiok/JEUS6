package asyncprovider.client;

public class AsyncClient {

    public static void main(String[] args) {
        Hello_Service service = new Hello_Service();
        Hello proxy = service.getHelloAsyncPort();

        System.out.println("###################################################");
        System.out.println("### JAX-WS Webservices examples - AsyncProvider ###");
        System.out.println("###################################################");
        System.out.println("Result: " + proxy.hello("Hello, Tmaxsoft!"));
    }
}
