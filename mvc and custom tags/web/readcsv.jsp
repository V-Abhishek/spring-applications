<%-- 
    Document   : readcsv
    Created on : Feb 15, 2020, 8:15:48 PM
    Author     : Abhishek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="records.xls" method="POST">
            <label>Please enter file name:
                <input type="text" name="fileName">
            </label>
            <br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
