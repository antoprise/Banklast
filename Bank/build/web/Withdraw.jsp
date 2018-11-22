<%-- 
    Document   : Withdraw
    Created on : Nov 22, 2018, 4:16:16 PM
    Author     : Student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Withdraw Page</title>
    </head>
    <body>
        <h1>Withdraw Page</h1>
        <form action="WithdrawServlet">
        Withdraw <input type="number" name="withdraw">
        <input type="submit" value="withdraw">
        <span class style="color: red">${status}</span>
        </form>
        <br>
        <a href="MyAccount.jsp">Back</a>
    </body>
</html>
