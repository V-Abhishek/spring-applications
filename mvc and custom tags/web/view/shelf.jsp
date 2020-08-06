<%-- 
    Document   : shelf
    Created on : Feb 16, 2020, 6:35:02 PM
    Author     : Abhishek
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
    </head>
    <body>
        <c:if test="${not empty requestScope.numberOfBooks}">
            <c:set var = "numberOfBooks" value = "${requestScope.numberOfBooks}"/>
            <c:out value="${numberOfBooks}"></c:out> books added successfully.
        </c:if>
        <br>
        <a href="book-store.html">Home Page</a>
    </body>
</html>
