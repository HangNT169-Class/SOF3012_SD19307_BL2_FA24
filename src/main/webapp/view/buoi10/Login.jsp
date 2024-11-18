<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 18/11/24
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${message}</h1>
<form action="/login" method="post">
    UserName:
    <input type="text" name="u1"><br>
    Password:
    <input type="password" name="p1"><br/>
    <button type="submit">Dang Nhap</button>
</form>


</body>
</html>
