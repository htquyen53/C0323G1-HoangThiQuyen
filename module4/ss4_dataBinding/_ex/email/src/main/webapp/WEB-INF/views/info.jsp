<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/20/2023
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Settings Information</title>
</head>
<body>
<c:if test="${mess!=null}">
    <span>${mess}</span>
</c:if>
<table>
    <tr>
        <th>Language</th>
        <td>${settings.language}</td>
    </tr>
    <tr>
        <th>Page Size</th>
        <td>${settings.pageSize}</td>
    </tr>
    <tr>
        <th>Spam filter</th>
        <td>
            <c:if test="${settings.spamsFilter == true}">Enable spam filter</c:if>
            <c:if test="${settings.spamsFilter == false}">None</c:if>
        </td>
    </tr>
    <tr>
        <th>Signature</th>
        <td>${settings.signature}</td>
    </tr>
    <tr>
        <td>
            <button type="button"><a href="/email-settings/update">Update</a></button>
        </td>
        <td>
        </td>
    </tr>
</table>
</body>
</html>
