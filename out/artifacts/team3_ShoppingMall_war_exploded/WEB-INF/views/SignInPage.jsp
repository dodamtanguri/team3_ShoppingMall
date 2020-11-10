<%--
  Created by IntelliJ IDEA.
  User: soheelim
  Date: 2020/11/10
  Time: 12:26 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>LogIn</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <style>
        .container {
            width: 385px;
            line-height: 50px;
            margin: 40px auto;
        }

        h5 {
            text-align: center;
        }

        h5 span {
            color: teal;
        }

        .login {
            background-color: rgb(255, 80, 90);
            color: white;
            border-radius: 5px;
            border: 0;
            padding: 10px 172px;
        }

        #signup {
            background-color: white;
            color: teal;
            border: 0;
            font-size: 17px;
        }

        p {
            text-align: center;
        }

        i {
            color: lightgray;
        }

        #imail {
            position: absolute;
            top: 130px;
            margin: 0 355px;
        }

        #ipw {
            position: absolute;
            top: 180px;
            margin: 0 355px;
        }

        input {
            border: 1px solid lightgray;
            border-radius: 3px;
        }
    </style>
</head>
<body>
<c:if test="${ loginResult == -1 || loginResult == 0 }">
    <script>
        alert("아이디 혹은 비밀번호가 틀렸습니다.");
    </script>
</c:if>
<c:if test="${sessionID != null }">
    <script>
        alert("이미 로그인 중입니다.");
    </script>
</c:if>
<form action="SignIn.do" method="post">
    <table>
        <tr><td>ID</td><td>
            <input type="text" name="id" size="24"></td></tr>

        <tr><td>PASSWORD</td><td>
            <input type="text" name="pwd" size="24"></td></tr>
    </table>
    <input type="submit" value="submit">
</form>
</body>
</html>
