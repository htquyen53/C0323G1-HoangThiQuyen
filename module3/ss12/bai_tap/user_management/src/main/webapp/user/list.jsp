<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/4/2023
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            font-size: x-large;
            margin-left: 20px;
            font-weight: bolder;
        }

        table {
            margin: 20px;
        }

        table, tr, td, th {
            border: 2px solid gray;
            padding: 5px;
            text-align: center;
            border-collapse: collapse;
        }

        h1 {
            text-align: center;
            color: black;
        }

        h2 {
            text-align: left;
            margin-left: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row"><h1><b>User Management</b></h1></div>
    <div class="row"><h2>
        <a class="btn btn-outline-danger" href="/UserServlet?action=create"><b>Add New User</b></a>
    </h2>
    </div>
    <div class="row" style="align-content: center">
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th colspan="3">Actions</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.country}"/></td>
                    <td>
                        <a class="btn btn-outline-primary btn-sm" href="/UserServlet?action=update&id=${user.id}">Edit</a>
                    </td>
                    <td>
                        <a class="btn btn-outline-danger btn-sm" href="/UserServlet?action=delete&id=${user.id}">Delete</a>
                    </td>
                    <td>
                        <a class="btn btn-outline-success btn-sm" href="/UserServlet?action=view&id=${user.id}">View</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</html>