package helloejb;

import java.io.*;
import javax.ejb.EJB;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * HelloEJB client servlet.
 */
public class HelloClient extends HttpServlet {
    @EJB
    private Hello hello;
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            // Call session bean business method.
            String msg = hello.sayHello();
            
            response.setContentType("text/html");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>HelloClient</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1>" + msg + "</h1></center>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        } catch(Exception ex){
            response.setContentType("text/plain");
            ex.printStackTrace(out);
        }
    }
    
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
}
