package trust.client;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPBinding;
import javax.xml.namespace.QName;
import java.io.FileInputStream;

import com.sun.xml.ws.security.trust.WSTrustConstants;
import java.net.URL;

public class FinancialServiceClient {

    public static final String COMPANY_NAME = "Tmaxsoft";
    public static final String DEPARTMENT_NAME = "Infra";

    public static void main(String[] args) {
        try {
            Department dept = new Department();
            dept.setCompanyName(COMPANY_NAME);
            dept.setDepartmentName(DEPARTMENT_NAME);

            FinancialService service = new FinancialService();
            IFinancialService stub = service.getIFinancialServicePort();
            // ((BindingProvider) stub).getRequestContext().put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:9999/trust_server/FinancialService");
            String balance = stub.getAccountBalance(dept);

            System.out.println("My Company name is \"" + COMPANY_NAME + "\"");
            System.out.println("My Department name is \"" + DEPARTMENT_NAME + "\"");
            System.out.println("Result Balance from FinancialService is '" + balance + "'");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
