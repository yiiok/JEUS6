<%@ page language="java" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.rmi.*" %>
<%@ page import="java.rmi.RemoteException" %>
<%@ page import="java.util.*" %>

<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.xml.rpc.Service" %>

<%@ page import="echo.*" %>
<%@ page errorPage="/error.html" %>

<%! String msgToSend = "msg_sent_by_jspClient";
    String ret = null;
    String exceptionString = "";
%>

<%
    try {
        InitialContext jndiContext = new InitialContext();
        DocLitEchoService service = (DocLitEchoService) jndiContext.lookup("java:comp/env/service/DocLitEchoService");
        Echo echoPort = service.getEchoPort();
        System.out.println("Send : " + msgToSend);
        ret = echoPort.echoString(msgToSend);
        System.out.println("You received : " + ret);
    } catch (Exception e) {
        exceptionString = e.toString();
        e.printStackTrace();
        System.err.println(exceptionString);
    }
%>

<%= "Result is " + ret + "......" 
%>

<%= exceptionString
%>
