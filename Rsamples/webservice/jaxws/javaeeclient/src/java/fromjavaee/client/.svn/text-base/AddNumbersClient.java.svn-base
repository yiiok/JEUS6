package fromjavaee.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

public class AddNumbersClient extends HttpServlet {

    @WebServiceRef
    static AddNumbersService svc;

    protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1)
            throws ServletException, IOException {
        AddNumbersPortType port = svc.getAddNumbersPort();
	java.io.PrintWriter out = arg1.getWriter();

        int number1 = 10;
        int number2 = 20;

        out.println("##############################################<br>");
        out.println("### JAX-WS Webservices examples - fromjava ###<br>");
        out.println("##############################################<br>");
        out.println("Testing JavaEE webservices client...<br>");
        int result = port.addNumbers(number1, number2);
        if (result == 30) {
            out.println("Success!<br>");
        } else {
            out.println("Fail!<br>");
        }
	out.close();
    }
}
