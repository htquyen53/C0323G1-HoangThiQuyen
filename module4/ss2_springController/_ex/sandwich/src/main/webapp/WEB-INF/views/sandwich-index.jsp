<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/19/2023
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich Menu</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        form {
            width: 70%;
        }
    </style>
</head>
<body>
<div class="container justify-content-center">
    <h1><b>Sandwich Condiments</b></h1>
    <form action="/sandwich" method="post">
        <label class="checkbox-inline"><input type="checkbox" name="condiment" value="Lettuce">Lettuce</label>
        <label class="checkbox-inline"><input type="checkbox" name="condiment" value="Tomato">Tomato</label>
        <label class="checkbox-inline"><input type="checkbox" name="condiment" value="Mustard">Mustard</label>
        <label class="checkbox-inline"><input type="checkbox" name="condiment" value="Sprouts">Sprouts</label>
        <hr>
        <button type="submit" class="btn btn-warning">Save</button>
    </form>
    <c:if test="${msg != null}">
        <span class="text text-danger">${msg}</span>
    </c:if>
    <c:if test="${listCondiment.size()>0}">
        <p>
            Your have selected:
        </p>
        <c:forEach var="co" items="${listCondiment}" varStatus="loop">
            <div>${loop.count}. ${co}</div>
            <br>
        </c:forEach>
    </c:if>

</div>
</body>
</html>
