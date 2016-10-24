<%-- 
    Document   : UnaAve
    Created on : 24-oct-2016, 20:29:42
    Author     : Daw2
--%>

<%@page import="beans.Aves"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Aves avion = (Aves) request.getAttribute("aves");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>UnaAve!</h1>
        <table>
            <tr>
                <td><strong>Anilla</strong></td>
                <td><strong>Especie</strong></td>
                <td><strong>Fecha</strong></td>
                <td><strong>Lugar</strong></td>
            </tr>
            <tr>
                <td><%=avion.getAnilla()%></td>
                <td> <%=avion.getEspecie()%></td>
                <td> <%=avion.getFecha()%></td>
                <td>  <%=avion.getLugar()%></td>
            </tr>
        </table>
    </body>
</html>
