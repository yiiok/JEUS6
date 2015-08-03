<%@ page language="java" %>
<%@ page import="java.io.File" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.rmi.*" %>
<%@ page import="java.rmi.RemoteException" %>
<%@ page import="java.util.*" %>

<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.xml.rpc.Service" %>

<%@ page import="FileAttachmentService_pkg.*" %>
<%@ page errorPage="/error.html" %>

<%! String exceptionString="";
%>

<%
        try {
            String realPath = application.getRealPath(request.getRequestURI());
            realPath = realPath.substring(0, realPath.lastIndexOf(System.getProperty("file.separator")));
            realPath = realPath.substring(0, realPath.lastIndexOf(System.getProperty("file.separator")) + 1);
            realPath = realPath + "File_send.txt";
            InitialContext jndiContext = new InitialContext();
            FileAttachmentService service = (FileAttachmentService) jndiContext.lookup("java:comp/env/service/FileAttachmentService");
            FileTransferIF port = service.getFileTransferIFPort();
            String result = port.receiveFile(realPath);
            System.out.println("** File transfer result: " + result);
        } catch (Exception e) {
            exceptionString = e.toString();
            e.printStackTrace();
            System.err.println(exceptionString);
        }
%>

<%= exceptionString
%>
