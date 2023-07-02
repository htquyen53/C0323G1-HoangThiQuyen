<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<h1><%= "Simple Calculator" %>
</h1>
<form action="/simple-calculator" method="post">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td>First oparand:</td>
                <td><input type="text" name="first operand" placeholder="enter here..."/></td>
            </tr>
            <tr>
                <td>Operator:</td>
                <td><select disabled="disabled" name="operator">
                    <option name="addition" value="+">Addition</option>
                    <option name="subtraction" value="-">Subtraction</option>
                    <option name="multiplication" value="*">Multiplication</option>
                    <option name="division" value="/">Division</option>
                </select>
                </td>
            </tr>
            <tr>
                <td>Second operand</td>
                <td><input type="text" name="second operand" placeholder="enter here..."/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" id="submit" name="Calculate"/>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>