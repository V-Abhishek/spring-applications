<%-- 
    Document   : logout
    Created on : Feb 7, 2020, 2:08:04 PM
    Author     : Abhishek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session.invalidate();
    response.sendRedirect("thankyou.jsp");
%> 
