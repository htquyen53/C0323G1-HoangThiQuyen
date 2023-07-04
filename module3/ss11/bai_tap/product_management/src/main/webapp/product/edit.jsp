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
    <title>Edit customer</title>
</head>
<body>
<h1>Update product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<form method="post">
    <fieldset>
        <legend>Thông tin sản phẩm</legend>
        <table>
           <tr>
               <td>Name: </td>
                <td><input type="text" name="name" id = "name" value="${requestScope["product"].getNameProduct()}"></td>
           </tr>
            <tr>
                <td>Price: </td>
                <td><input type="number" name="price" id = "price" value="${requestScope["product"].getPriceProduct()}"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" id = "description" value="${requestScope["product"].getDescription()}"></td>
            </tr>
            <tr>
                <td>Manufacturer: </td>
                <td><input type="text" name="manufacturer" id = "manufacturer" value="${requestScope["product"].getManufacturer()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
        <a href="/ProductServlet">Trở về danh sách</a>
    </fieldset>
</form>
</body>
</html>
