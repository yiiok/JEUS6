import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import cardfile.Address;
import cardfile.BusinessCard;

public class Main {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(BusinessCard.class);

            //
            BusinessCard card = new BusinessCard("John Doe", "Sr. Widget Designer", "Acme, Inc.",
                new Address(null, "123 Widget Way", "Anytown", "MA", (short) 12345),
                "123.456.7890", null, "123.456.7891", "John.Doe@Acme.ORG");

            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(card, new FileOutputStream(new File("src/conf/bcard.xml")));

            //
            Unmarshaller um = context.createUnmarshaller();
            Schema schema = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI).newSchema(Main.class.getResource("schema1.xsd"));
            um.setSchema(schema);
            Object bce = um.unmarshal(new File("src/conf/bcard.xml"));
            m.marshal(bce, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
