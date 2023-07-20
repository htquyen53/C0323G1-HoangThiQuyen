<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/20/2023
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Settings Information Form</title>
</head>
<body>
<form:form modelAttribute="settings" action="/email-settings/update" method="post">
    <table>
        <tr>
            <th>Language</th>
            <td>
                <form:select path="language">
                    <form:options items="${languages}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Page Size</th>
            <td>
                Show
                <form:select path="pageSize">
                    <form:options items="${pageSize}"/>
                </form:select> email per page
            </td>
        </tr>
        <tr>
            <th>Spam filter</th>
            <td>
                <form:checkbox path="spamsFilter" label="Enable spam filter"/>
            </td>
        </tr>
        <tr>
            <th>Signature</th>
            <td>
                <form:textarea path="signature" rows="5" cols="50"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">Update</button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
