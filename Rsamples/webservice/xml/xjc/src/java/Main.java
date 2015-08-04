import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import com.tmaxsoft.*;

public class Main {

    public static void main(String[] args) {
        try {
            Schema schema = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI).newSchema(new File("src/conf/ts.xsd"));

            JAXBContext jc = JAXBContext.newInstance("com.tmaxsoft");

            //
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshaller.setSchema(schema);

            Object ts = unmarshaller.unmarshal(new File("src/conf/tsInput.xml"));
            TmaxSoftType tst = (TmaxSoftType) ((JAXBElement) ts).getValue();
            Address address = tst.getAddress1();
            address.setName("John Bob");
            address.setStreet("242 Main Street");
            address.setCity("Beverly Hills");

            //
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setSchema(schema);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(ts, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
