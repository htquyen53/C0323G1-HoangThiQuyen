<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/19/2023
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Caculator</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        form {
            width: 100%;
        }

        h1 {
            text-align: center;
        }

        .form input {
            position: relative;
            width: 60%;
            left: 50%;
            transform: translateX(-50%);
        }

        .buttons {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 1rem;
        }

        button {
            margin-left: 5px;
        }

        .container {
            background-color: darkseagreen;
            display: flex;
            justify-content: center;
            flex-direction: column;
            align-content: center;
        }
        .result {
            width: 40%;
            position: relative;
            margin-bottom: 3rem;
            left: 50%;
            transform: translateX(-50%);
        }
        .form {
            width: 70%;
            position: relative;
            left: 50%;
            transform: translateX(-50%);
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form">
        <form action="/caculator" method="post" class="form-group">
            <legend><h1>CALCULATOR</h1></legend>
            <input class="form-control" type="number" id="firstOperator" name="firstOperator"
                   placeholder="Enter a number..." value="${firstOperator}" required>
            <input class="form-control" type="number" id="secondOperator" name="secondOperator"
                   placeholder="Enter a number..." value="${secondOperator}" required>
            <div class="buttons">
                <button class="btn btn-primary" type="submit" value="+" name="operator">Addition(+)</button>
                <button class="btn btn-success" type="submit" value="-" name="operator">Subtraction(-)</button>
                <button class="btn btn-warning" type="submit" value="*" name="operator">Multiplication(x)</button>
                <button class="btn btn-danger" type="submit" value="/" name="operator">Division(/)</button>
            </div>
        </form>
    </div>
    <div class="result">
        <c:if test="${msg!=null}">
            <span class="text text-danger">${msg}</span>
        </c:if>
        <c:if test="${msg==null}" >
            <h3>Result: ${result}</h3>
        </c:if>
    </div>
</div>
</body>
</html>
