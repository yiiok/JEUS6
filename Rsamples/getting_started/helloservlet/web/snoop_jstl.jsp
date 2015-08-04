<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
<body>
<h2> Request Information </h2>
<font size="4">
    <c:set var="req" value="${pageContext.request}"/>
    JSP Request Method: <c:out value="${req.method}"/>
    <br/>
    Request Protocol: <c:out value="${req.protocol}"/>
    <br/>
    Servlet path: <c:out value="${req.servletPath}"/>
    <br/>
    Path info: <c:out value="${req.pathInfo}"/>
    <br/>
    Path translated: <c:out value="${req.pathTranslated}"/>
    <br/>
    Query string: <c:out value="${req.queryString}"/>
    <br/>
    Content length: <c:out value="${req.contentLength}"/>
    <br/>
    Content type: <c:out value="${req.contentType}"/>
    <br/>
    Server name: <c:out value="${req.serverName}"/>
    <br/>
    Server port: <c:out value="${req.serverPort}"/>
    <br/>
    Remote user: <c:out value="${req.remoteUser}"/>
    <br/>
    Remote address: <c:out value="${req.remoteAddr}"/>
    <br/>
    Remote host: <c:out value="${req.remoteHost}"/>
    <br/>
    Authorization scheme: <c:out value="${req.authType}"/> 
    <hr/>
    <f:view>
    The browser you are using is <h:outputText value=
    "#{header['User-Agent']}"/>
    </f:view>
    <hr/>
</font>
</body>
</html>
