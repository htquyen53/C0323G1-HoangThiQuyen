<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/18/2023
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Dictionary</title>
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
<div class="container justify-content-center">
    <div>
        <form action="/dictionary/search" method="post">
            <div style="text-align: center">
                <legend><h2>SEARCH YOUR WORD</h2></legend>
            </div>
            <div>
                <table class="table">
                    <tr>
                        <th>Search Word:</th>
                        <td><input type="text" id="searchWord" name="searchWord" placeholder="Enter here..." value="${searchWord}"></td>
                    </tr>
                    <tr>
                        <th>Meaning:</th>
                        <td id="result">${result}
                        <small class="text text-danger">${msg}</small></td>
                    </tr>
                    <tr>
                        <td><button type="submit" class="btn btn-success">Search</button></td>
                        <td><button type="reset" class="btn btn-danger"><a href="/dictionary" style="text-decoration: none; color: black" >Back</a></button> </td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous">
</script>
</html>
