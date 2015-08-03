package mtom.client;

import java.awt.Image;
import java.io.File;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.soap.SOAPBinding;

public class MtomApp {

    public static void main(String[] args) {
        try {
            Hello port = new HelloService().getHelloPort();
            SOAPBinding binding = (SOAPBinding) ((BindingProvider) port)
                    .getBinding();
            binding.setMTOMEnabled(true);

            Holder<Image> image = new Holder<Image>(javax.imageio.ImageIO
                    .read(new File("./src/conf/Tmaxsoft.jpg")));
            port.detail(image);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
