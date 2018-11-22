<%-- 
    Document   : MyAccount
    Created on : Nov 22, 2018, 3:37:14 PM
    Author     : Student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Account Page</title>
    </head>
    <body>
        <h1>My Account</h1>
        <h2>Hello , ${accountObj.name}</h2>
        <h2>Balance : ${accountObj.balance}</h2>
        <span class style="color: red">${status}</span>
        <h3><a href="DepositServlet">deposit</a></h3>
        <h3><a href="WithdrawServlet">withdraw</a></h3>
        <h3><a href="HistoryServlet">history</a></h3>
        <br>
        <h3><a href="LogoutServlet">Logout</a></h3>
    </body>
</html>
