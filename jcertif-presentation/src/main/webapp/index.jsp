<%-- 
    Document   : index
    Created on : 28-Feb-2011, 19:48:22
    Author     : UNHCRUser
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JCertif 2011</title>
    </head>
    <body>

        <%
                    String destination = "pages/home.jsp";
                    response.sendRedirect(response.encodeRedirectURL(destination));
        %>
    </body>
</html>
