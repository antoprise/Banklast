<%-- 
    Document   : Deposit
    Created on : Nov 22, 2018, 3:33:48 PM
    Author     : Student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deposit Page</title>
    </head>
    <body>
        <h1>Deposit Page</h1>
        <form action="DepositServlet">
            deposit : <input type="number" name="deposit" maxlength="5" title="max valid">
            <span class style="color: red">${status}</span>
            <input type="submit" value="deposit">
        </form>
            <br>
            
            <a href="MyAccount.jsp">Back</a>
      
    </body>
</html>
