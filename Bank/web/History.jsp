<%-- 
    Document   : History
    Created on : Nov 22, 2018, 3:42:10 PM
    Author     : Student
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HistoryPage</title>
    </head>
    <body>
        <h1>History Page</h1>
        <table border="1">
            <tr>
                <td>#</td>
                <td>TimeStamp</td>
                <td>Methods</td>
                <td>Amount</td>
                <td>Balance</td>
                
            </tr>
            <c:forEach items="${accountObj.historyList}" var="h" varStatus="vs">
                <tr>
                    <td>${vs.count}</td>
                    <td>${h.time}</td>
                    <td>${h.method}</td>
                    <td>${h.amount}</td>
                    <td>${h.balance}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="MyAccount.jsp">Back</a>
    </body>
</html>
