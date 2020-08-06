<%-- 
    Document   : movie-results
    Created on : Feb 28, 2020, 4:42:44 AM
    Author     : Abhishek
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
        <h1>Results</h1>
        <c:set var = "searchword" value = "${requestScope.searchword}"/>
        <h3>You Searched for <c:out value = "${searchword}"/></h3>
        <c:choose>
            <c:when test="${empty movieList}">
                <h2>No Movie/Movies Found</h2>
            </c:when>
            <c:otherwise>
                <c:forEach items="${movieList}" var = "movie">
                    <label>Movie Title: </label><c:out value="${movie.movieName}"/><br>
                    <label>Lead Actor: </label><c:out value="${movie.actor}"/><br>
                    <label>Lead Actress: </label><c:out value="${movie.actress}"/><br>
                    <label>Genre: </label><c:out value="${movie.genre}"/><br>
                    <label>Year: </label><c:out value="${movie.year}"/><br>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <a href="movie-store.html">Home Page</a>
    </body>
</html>
