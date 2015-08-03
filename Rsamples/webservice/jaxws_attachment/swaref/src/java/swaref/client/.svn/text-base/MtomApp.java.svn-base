package swaref.client;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.activation.DataHandler;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.soap.SOAPBinding;

public class MtomApp {

    public static void main(String[] args) {
        try {
            Hello port = new HelloService().getHelloPort();

            // SOAPBinding binding = (SOAPBinding) ((BindingProvider) port)
            // .getBinding();
            // binding.setMTOMEnabled(true);

            DataHandler claimForm = new DataHandler(new StreamSource(
                    new FileInputStream("./src/conf/hello.wsdl")), "text/xml");
            DataHandler out = port.claimForm(claimForm);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
