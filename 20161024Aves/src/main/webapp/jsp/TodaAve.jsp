<%-- 
    Document   : TodaAve
    Created on : 24-oct-2016, 20:29:54
    Author     : Daw2
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Aves"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ArrayList<Aves> array = (ArrayList) request.getAttribute("pollos");
    Iterator<Aves> it = array.iterator();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Todas!</h1>
        <table>
            <tr>
                <td><strong>Anilla</strong></td>
                <td><strong>Especie</strong></td>
                <td><strong>Fecha</strong></td>
                <td><strong>Lugar</strong></td>
            </tr>
        <%
            while (it.hasNext()) {
                 Aves polluelo = it.next();
           
            %>
            <tr>
                <td><%=polluelo.getAnilla() %></td>
                <td><%=polluelo.getEspecie() %></td>
                <td><%=polluelo.getFecha() %></td>
                <td><%=polluelo.getLugar() %></td>
            </tr>
            <%  }
                %>
        </table>
    </body>
</html>
