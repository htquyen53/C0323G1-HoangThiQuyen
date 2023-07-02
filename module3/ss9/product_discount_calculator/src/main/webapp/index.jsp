<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products Discount Calculator</title>

</head>
<body>
<form action="/discount" method="post">
    <label>Product Description: </label><br/>
    <input type="text" name="description" placeholder="Enter description..."><br/>
    <label>List Price: </label><br/>
    <input type="number" name="price" placeholder="Enter price..."><br/>
    <label>Discount Percent: </label><br/>
    <input type="number" name="discount" placeholder="%"><br/>
    <input type="submit" id="submit" value="Calculator">
</form>
</body>
</html>