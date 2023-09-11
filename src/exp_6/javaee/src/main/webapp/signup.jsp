<%--
  Created by IntelliJ IDEA.
  User: Mihir
  Date: 11-09-2023
  Time: 07:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sign Up</title>
</head>
<body>
<form action="signup" method="post">
<table>
    <tr>
        <td>
            Enter username:
        </td>
        <td>
            <input type="text" name="username" required="required">
        </td>
    </tr>
    <tr>
        <td>
            Enter Password:
        </td>
        <td>
            <input type="text" name="password" required="required">
        </td>
    </tr>
</table>
<input type="submit" name="submit">
</form>
</body>
</html>
