<%@ page language="java" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.rmi.*" %>
<%@ page import="java.rmi.RemoteException" %>
<%@ page import="java.util.*" %>

<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.xml.rpc.Service" %>
<%@ page import="javax.xml.rpc.Call" %>
<%@ page import="javax.xml.namespace.QName" %>
<%@ page import="javax.xml.rpc.ParameterMode" %>

<%@ page errorPage="/error.html" %>

<%! String msgToSend = "msg_sent_by_jspClient";
    String ret=null;
    String exceptionString="";
%>

<%
        
        try {
            
            InitialContext jndiContext = new InitialContext();
            Service service = (Service)jndiContext.lookup("java:comp/env/service/RpcEncEchoService");
            String targetNamespace = "urn:RpcEncService";
            QName operationName = new QName(targetNamespace, "echoString");
            
            Call call = service.createCall();
            call.setOperationName(operationName);
            
            call.addParameter("String_1", new QName("http://www.w3.org/2001/XMLSchema", "string"), ParameterMode.IN);

			call.setProperty(Call.OPERATION_STYLE_PROPERTY, "rpc");
			call.setProperty(Call.ENCODINGSTYLE_URI_PROPERTY, "http://schemas.xmlsoap.org/soap/encoding/");

            call.setReturnType(new QName("http://www.w3.org/2001/XMLSchema","string"));            
                        
            call.setTargetEndpointAddress("http://localhost:8088/RpcEncEchoService/RpcEncEchoService");
            
            ret = (String)call.invoke(new Object[]{msgToSend});

        } catch (Exception e) {
            exceptionString = e.toString();
            e.printStackTrace();
        }
%>

<%= "Result is "+ret+"......" 
%>

<%= exceptionString
%>
