<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/4/2023
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>User Management Application</title>
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
            text-align: center;
            color: red;
        }
    </style>
    <style>
        table {
            border: 1px solid blue;
        }
        tr,th,td {
            border: 1px solid blue;
        }
    </style>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a class="btn btn-outline-danger" href="/UserServlet?action=create">Add New User</a>
    </h2>
</center>
<center>
<div style="align-content: center">
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a class="btn btn-primary btn-sm" href="/UserServlet?action=update&id=${user.id}">Edit</a>
                    <a class="btn btn-danger btn-sm" href="/UserServlet?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</center>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</html>