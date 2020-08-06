<%-- 
    Document   : viewcart
    Created on : Feb 8, 2020, 11:36:40 PM
    Author     : Abhishek
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <h1>Your Cart Items</h1>
        <c:if test="${not empty sessionScope.cartList}">
            <form action="../managecart.htm?action=modify" method="post">
                <table border="1">
                    <c:forEach items="${sessionScope.cartList}" var="products">
                        <tr>
                            <td><c:out value="${products}" /><br/></td>
                            <td><input type="checkbox" name="products" value="${products}"/>Remove product</td>
                        </tr>                  
                    </c:forEach>        
                </table>
                <input type="submit" value="Remove Products" />
            </c:if>
        </form>
    </body>
</html>
