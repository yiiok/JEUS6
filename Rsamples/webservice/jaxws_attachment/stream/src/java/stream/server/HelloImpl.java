package stream.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.jws.WebService;

@WebService(endpointInterface = "stream.server.Hello", wsdlLocation = "WEB-INF/wsdl/hello.wsdl", targetNamespace = "http://tmaxsoft.com/stream", serviceName = "HelloService", portName = "HelloPort")
public class HelloImpl implements Hello {

    public DataHandler claimForm(String name, DataHandler claimPhoto) {
        File file = new File(name);
        File inFile = new File(file.getParentFile(), "Req_" + file.getName());
        try {
            write(claimPhoto.getInputStream(), inFile);
            return new DataHandler(new FileDataSource(inFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void write(InputStream in, File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) != -1) {
            os.write(buffer, 0, length);
        }
        os.close();
    }

}
