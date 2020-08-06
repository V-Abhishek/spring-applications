<%-- 
    Document   : AddBook
    Created on : Feb 16, 2020, 5:25:25 PM
    Author     : Abhishek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
    </head>
    <body>
        <c:if test="${not empty requestScope.numberOfBooks}">
            <c:set var = "numberOfBooks" value = "${requestScope.numberOfBooks}"/>
            <form action="book-store-controller.htm" method="POST">
                <table border="2">
                    <thead>
                        <tr>
                            <th>ISBN</th>
                            <th>Book Title</th>
                            <th>Authors</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var = "i" begin = "1" end = "${numberOfBooks}">
                            <tr>
                                <td><input type="text" name="isbn_${i}" required></td>
                                <td><input type="text" name="title_${i}" required></td>
                                <td><input type="text" name="authors_${i}" required></td>
                                <td><input type="text" name="price_${i}" required></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <input type="hidden" name="valuesList" value="${numberOfBooks}">
                <input type="hidden" name="action" value="DB">
                <input type="submit" value="Add Books">  
            </form>
        </c:if>
    </body>
</html>
