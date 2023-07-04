<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/3/2023
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            margin-left: 20px;
        }
        table, tr, td, th {
            border: 2px solid blue;
            padding: 5px;
            text-align: center;
            border-collapse: collapse;
        }

        h1 {
            text-align: left;
            color: red;
        }
    </style>
</head>
<br>
<h1>Products</h1>
<br>
<a href="/ProductServlet?action=create">Thêm mới</a></br>
<a href="/ProductServlet?action=delete">Xóa sản phẩm</a></br>
<a href="/ProductServlet?action=view">Tìm kiếm sản phẩm</a></br>
<p style="color: cadetblue; font-weight: bold">
<c:if test="${msg != null}">
    <c:out value="${msg}"/>
</c:if>
</p>
<table>
    <tr>
        <th>STT:</th>
        <th>Tên sản phẩm:</th>
        <th>Giá:</th>
        <th>Mô tả:</th>
        <th>Nhà sản xuất:</th>
        <th></th>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="loop">
        <tr>
            <td><c:out value="${loop.count}"/></td>
            <td><c:out value="${product.getNameProduct()}"/></td>
            <td><c:out value="${product.getPriceProduct()}"/></td>
            <td><c:out value="${product.getDescription()}"/></td>
            <td><c:out value="${product.getManufacturer()}"/></td>
            <td><a href="/ProductServlet?action=update&id=${product.getIdProduct()}" class="btn btn-primary">Chỉnh sửa</a></td>
        </tr>
    </c:forEach>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
