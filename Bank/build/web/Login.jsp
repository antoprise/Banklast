<%-- 
    Document   : Login
    Created on : Nov 22, 2018, 3:32:01 PM
    Author     : Student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="LoginServlet">
        user : <input type="number" name="id">
        <br>
        password : <input type="password" name="password">
        <br>
        <span class style="color: red">${message}</span>
        <input type="submit" value="Login">
        </form>
    </body>
</html>
