<%--
  Created by IntelliJ IDEA.
  User: soheelim
  Date: 2020/11/09
  Time: 3:06 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    System.out.println("3");
%>
<html>
<head>
    <title>Sign Up MEMBER</title>
</head>
<body>
<form action="SignUp.do" method="post">
    <table>
       <tr><td>ID</td><td>
        <input type="text" name="id" size="24"></td></tr>

        <tr><td>PASSWORD</td><td>
            <input type="text" name="pwd" size="24"></td></tr>

        <tr><td>NAME</td><td>
            <input type="text" name="name" size="24"></td></tr>

        <tr><td>HP</td><td>
            <input type="text" name="hp" size="24"></td></tr>
        <tr><td>CARDNUMBER</td><td>
            <input type="text" name="card_num" size="24"></td></tr>
        <tr><td>ADDRESS</td><td>
            <input type="text" name="address" size="24"></td></tr>
    </table>
    <input type="submit" value="submit">
</form>
</body>
</html>
