<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/3/2023
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>Product Details</h1>
<p>
    <a href="/ProductServlet"> Quay lại trang danh sách</a>
</p>
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
        <td>${requestScope["product"].getmanufacturer()}</td>
    </tr>
</table>
<a href="/ProductServlet">Trở về danh sách</a>
</body>
</html>
