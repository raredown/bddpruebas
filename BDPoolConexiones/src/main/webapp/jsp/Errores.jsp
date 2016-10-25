<%-- 
    Document   : Errores
    Created on : 24-oct-2016, 20:29:27
    Author     : Daw2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Error!</h1>
        <h2><%=request.getAttribute("error") %></h2>
    </body>
</html>
