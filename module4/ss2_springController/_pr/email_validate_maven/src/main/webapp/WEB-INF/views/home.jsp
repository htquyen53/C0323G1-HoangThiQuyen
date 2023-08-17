<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/19/2023
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>EMAIL VALIDATE</h1>
<H3 style="color: red">${message}</H3>
<form action="/validate" method="post">
    <input type="text" name="email"><br>
    <input type="submit" value="Validate">
</form>
</body>
</html>
