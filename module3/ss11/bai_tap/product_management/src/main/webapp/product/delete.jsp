<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/3/2023
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/ProductServlet">Quay lại danh sách</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product Information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["product"].getNameProduct()}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${requestScope["product"].getPriceProduct()}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${requestScope["product"].getDescription()}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${requestScope["product"].getManufacturer()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete"></td>
                <td><a href="/ProductServlet">Quay lại danh sách</a> </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
