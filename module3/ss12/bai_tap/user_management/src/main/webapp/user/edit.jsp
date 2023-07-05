<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/4/2023
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user information</title>
</head>
<body>
<h1>Update user</h1>
<p>
    <c:if test='${"message"!= null}'>
        <span class="message">${"message"}</span>
    </c:if>
</p>
<form method="post">
    <fieldset>
        <legend>User Information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id = "name" value="${requestScope["user"].getName()}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="email" id = "email" value="${requestScope["user"].getEmail()}"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="country" id = "country" value="${requestScope["user"].getCountry()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update user"></td>
            </tr>
        </table>
        <a href="/UserServlet">Comeback List of users</a>
    </fieldset>
</form>
</body>
</html>
