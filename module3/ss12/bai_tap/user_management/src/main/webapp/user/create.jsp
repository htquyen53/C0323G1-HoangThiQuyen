<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/4/2023
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Create User</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Add new user</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td><input type="number" name="id" id="id"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>Country: </td>
                <td><input type="text" name="country" id="country"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="submit" value="Submit"></td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/UserServlet">Comeback List</a>
<c:if test="${msg != null}">
    <c:out value="${msg}"/>
</c:if>
</body>
</html>
