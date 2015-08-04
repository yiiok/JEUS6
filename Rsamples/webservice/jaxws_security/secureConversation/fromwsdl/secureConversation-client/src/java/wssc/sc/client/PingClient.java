package wssc.sc.client;

import javax.xml.ws.Holder;

public class PingClient {

    public static void main(String[] args) {
        IPingService pingPort = new PingService().getPingPort();
        pingPort.ping(new Holder("1"), new Holder("tmax"), new Holder("Passed!"));
        pingPort.ping(new Holder("2"), new Holder("tmax"), new Holder("Passed!"));
        pingPort.ping(new Holder("3"), new Holder("tmax"), new Holder("Passed!"));
    }
}
