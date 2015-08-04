package stream.client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.ws.BindingProvider;

public class AttachmentApp {

    public static void main(String[] args) {
        try {
            Hello port = new HelloService().getHelloPort();
            
            Map<String, Object> reqCnt = ((BindingProvider)port).getRequestContext();
            reqCnt.put("com.sun.xml.ws.transport.http.client.streaming.chunk.size",
                       new Integer(4*1024));

            File file = new File("./src/conf/Tmaxsoft.jpg");
            DataHandler claimPhoto = new DataHandler(new FileDataSource(file));
            
            DataHandler out = port.claimForm(file.getCanonicalPath(), claimPhoto);
			InputStream is = out.getInputStream();

	        File outFile = new File(file.getParentFile(), "Res_" + file.getName());
            write(claimPhoto.getInputStream(), outFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static void write(InputStream in, File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) != -1) {
            os.write(buffer, 0, length);
        }
        os.close();
    }
    
}
