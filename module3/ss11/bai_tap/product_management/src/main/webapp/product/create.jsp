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
    <title>Create new product</title>
</head>
<body>
<h1>Create new product</h1>
<form method="post" style="width: 500px">
    <fieldset>
        <legend>Thêm sản phẩm mới</legend>
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="number" name="id" id="id"></td>
            </tr>
            <tr>
                <td>Tên sản phẩm:</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Giá sản phẩm:</td>
                <td><input type="number" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Mô tả: </td>
                <td><input type="text" name="description" id="description"></td>
            </tr>
            <tr>
                <td>Nhà sản xuất: </td>
                <td><input type="text" name="manufacturer" id="manufacturer"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Create"></td>
                <td></td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/ProductServlet">Trở về danh sách</a>
<c:if test="${msg != null}">
    <c:out value="${msg}"/>
</c:if>
</body>
</html>
