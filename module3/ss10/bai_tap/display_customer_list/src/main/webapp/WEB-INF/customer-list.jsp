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
</head>
<body>
<table>
    <jsp:useBean id="customerList" scope="request" type="java.util.List"/>
    <c:forEach var="customer" items="${customerList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td><c:out value="${customer.name}"/></td>
            <td><c:out value="${customer.birthday}"/></td>
            <td><c:out value="${customer.address}"/></td>
            <td><c:out value="${customer.img}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
