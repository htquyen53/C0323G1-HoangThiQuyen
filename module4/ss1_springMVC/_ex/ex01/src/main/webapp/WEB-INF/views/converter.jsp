<%--
  Created by IntelliJ IDEA.
  User: Quinn
  Date: 7/18/2023
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Currency Converter</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <style>
        input {
            border: 1px pink;
        }

        form {
            border: 3px solid pink;
        }

        td {
            text-align: left;
        }
    </style>

</head>
<body>
<div class="container justify-content-center" style="width: 500px">
    <form action="/currency_converter/converter" method="post" class="row mt-1" id="formInput">
        <div style="text-align: center">
            <legend><h2>CURRENCY CONVERTER</h2></legend>
        </div>
        <div>
            <table class="table mt-1">
                <tr>
                    <th>USD</th>
                    <td><input type="number" id="usd" name=usd placeholder="Enter usd..." value="${usd}"></br>
                    <small class="text text-danger">${message}</small></td>
                </tr>
                <tr>
                    <th>VND</th>
                    <td id="vnd">${vnd}</td>
                </tr>
                <tr>
                    <td style="text-align: center">
                        <button type="submit" class="btn btn-success">Converter</button>
                    </td>
                    <td style="text-align: center">
                        <button type="reset" class="btn btn-danger"><a href="/currency_converter/form" style="text-decoration: none; color: white">Back</a></button>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous">
</script>
</html>
