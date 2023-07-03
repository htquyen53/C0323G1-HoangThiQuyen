<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/30/2023
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DANH SÁCH KHÁCH HÀNG</title>
    <style>
        table {
            border: 1px solid blue;
            align-content: center;
        }
        td, th {
            border: 1px solid blue;
        }
    </style>
</head>
<body>
<table>
    <jsp:useBean id="customerList" scope="request" type="java.util.List"/>
    <c:forEach var="customer" items="${customerList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>"${customer.name}"</td>
            <td>"${customer.birthday}</td>
            <td>"${customer.address}</td>
            <td><img src="${customer.img}" style="width: 100px; height: 100px"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
