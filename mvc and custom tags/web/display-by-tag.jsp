<%-- 
    Document   : display-by-tag
    Created on : Feb 17, 2020, 7:32:46 PM
    Author     : Abhishek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/customTld.tld" prefix="display" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display By Tag</title>
    </head>
    <body>
        <display:ViewCSV fileName="SalesOrder"></display:ViewCSV>
    </body>
</html>
