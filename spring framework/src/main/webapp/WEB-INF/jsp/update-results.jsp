<%-- 
    Document   : update-results
    Created on : Mar 6, 2020, 4:52:23 PM
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
        <c:set var = "searchword" value = "${requestScope.searchword}"/>
        <h1>Update ${searchword} Movie Details</h1>
        <form action="#" method="post">
            <div>
                <c:choose>
                    <c:when test="${empty movieList}">
                        <h2>No Movie/Movies Found</h2>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${movieList}" var = "movie">
                            <label>Movie Name*:
                                <input type="text" name="movieName"  value="${movie.movieName}" readonly>
                            </label><br>
                            <label>Lead Actor:
                                <input type="text" name="actor" value="${movie.actor}">
                            </label><br>
                            <label>Lead Actress:
                                <input type="text" name="actress" value="${movie.actress}">
                            </label><br>
                            <label>Genre:
                                <input type="text" name="genre" value="${movie.genre}">
                            </label><br>
                            <label>Year*:
                                <input type="text" name="year" value="${movie.year}" required>
                            </label><br><br>
                            <input type="hidden" name="id" value="${movie.id}">
                            <Label>Select Mapping*:</Label><br>
                            <input type="radio" class="input-hidden" name="selUrl" value="moviesController.htm" required/>SimpleUrlHandlerMapping
                            <input type="radio" class="input-hidden" name="selUrl" value="beanMoviesController.htm"/>BeanNameUrlHandlerMapping
                            <input type="radio" class="input-hidden" name="selUrl" value="viaclass.htm"/>ControllerClassNameHandlerMapping
                            <input type="radio" class="input-hidden" name="selUrl" value="interceptor.htm"/>Interceptor
                            <input type="radio" class="input-hidden" name="selUrl" value="filter.htm"/>Filter<br><br>
                            <input type="submit" value="Submit">
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                <input type="hidden" name="action" value="updation">
            </div>
        </form>
    </body>
    <script>
        var radios = document.getElementsByClassName('input-hidden');
        for (var i = 0; i < radios.length; i++) {
            radios[i].addEventListener('change', function (e) {
                document.getElementById('movieForm').setAttribute('action', e.target.value);
            }, false);
        }
    </script>
</html>

