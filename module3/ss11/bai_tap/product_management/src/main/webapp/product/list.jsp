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
    <title>Product List</title>
    <style>
        table {
            border: 1px solid blue;
        }
        th, td {
            border: 1px solid blue;
        }
    </style>
</head>
<body>
<h1>Products</h1>
<br>
    <a href="/ProductServlet?action=create">Thêm mới</a></br>
    <c:if test="${msg != null}">
        <c:out value="${msg}"/>
    </c:if>
</p>
<table>
    <tr>
        <th>STT: </th>
        <th>Tên sản phẩm: </th>
        <th>Giá: </th>
        <th>Mô tả: </th>
        <th>Nhà sản xuất: </th>
    </tr>
    <c:forEach items="${products}" var = "product" varStatus="loop">
        <tr>
            <td><c:out value="${loop.count}"/></td>
            <td><c:out value="${product.getNameProduct()}"/></td>
            <td><c:out value="${product.getPriceProduct()}"/></td>
            <td><c:out value="${product.getDescription()}"/></td>
            <td><c:out value="${product.getManufacturer()}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
