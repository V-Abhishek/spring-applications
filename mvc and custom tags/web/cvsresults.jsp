<%-- 
    Document   : cvsresults
    Created on : Feb 15, 2020, 8:52:19 PM
    Author     : Abhishek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.ResultSetMetaData" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>

        <%
            if (request.getAttribute("data") != null) {
                ResultSet results = (ResultSet) request.getAttribute("data");
                ResultSetMetaData rsmd = results.getMetaData();
                int columnsNumber = results.getMetaData().getColumnCount();
                while (results.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) {
                            out.print(" || ");
                        }
                        String columnValue = results.getString(i);
                        out.print(rsmd.getColumnName(i) + " : " + columnValue);
                    }
                    out.println("<br>");
                }
            } else {
        %>
        <h1>No Results Found<h1>
                <%
                    }
                %>
     </body>
</html>
