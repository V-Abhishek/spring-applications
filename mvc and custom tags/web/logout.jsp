<%-- 
    Document   : logout
    Created on : Feb 16, 2020, 1:30:47 AM
    Author     : Abhishek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.logout();
    session.invalidate();
    response.sendRedirect("thankyou.jsp");
%>
