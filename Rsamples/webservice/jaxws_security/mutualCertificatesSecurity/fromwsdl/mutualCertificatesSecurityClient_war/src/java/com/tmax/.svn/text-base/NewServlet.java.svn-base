package com.tmax;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.ws.WebServiceRef;

public class NewServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "http://localhost:8088/mutualCertificatesSecurity_war/serverwar?wsdl")
    private com.tmax.NewWebServiceService service;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet NewServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
        try {
            com.tmax.NewWebService port = service.getNewWebServicePort();
            int a = 3;
            int b = 4;
            int result = port.add(a, b);
            out.println("Result = " + result);
        } catch (Exception ex) {
            out.println(ex);
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }
}
