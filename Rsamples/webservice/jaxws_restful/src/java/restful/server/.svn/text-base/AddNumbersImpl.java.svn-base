package restful.server;

import java.io.ByteArrayInputStream;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingType;
import javax.xml.ws.Provider;
import javax.xml.ws.Service;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;
import javax.xml.ws.http.HTTPException;

@WebServiceProvider(serviceName = "AddNumbersService")
@ServiceMode(value = Service.Mode.MESSAGE)
@BindingType(value = HTTPBinding.HTTP_BINDING)
public class AddNumbersImpl implements Provider<Source> {

    @Resource(type = Object.class)
    protected WebServiceContext wsContext;

    public Source invoke(Source source) {
        try {
            MessageContext mc = wsContext.getMessageContext();
            String query = (String) mc.get(MessageContext.QUERY_STRING);
            StringTokenizer st = new StringTokenizer(query, "=&/");
            st.nextToken();
            int number1 = Integer.parseInt(st.nextToken());
            st.nextToken();
            int number2 = Integer.parseInt(st.nextToken());
            int sum = number1 + number2;
            String body = "<ns:addNumbersResponse xmlns:ns=\"urn:AddNumbers\"><ns:return>"
                    + sum + "</ns:return></ns:addNumbersResponse>";
            Source resultsrc = new StreamSource(new ByteArrayInputStream(body
                    .getBytes()));
            return resultsrc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
