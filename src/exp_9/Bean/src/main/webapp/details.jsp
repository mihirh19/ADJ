<%--
  Created by IntelliJ IDEA.
  User: Mihir
  Date: 26-09-2023
  Time: 12:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="bean" class="com.example.bean.SetBeans" scope="session"/>

<h1> Name  : <jsp:getProperty name="bean" property="name"/></h1>
<h1>Roll no : <jsp:getProperty name="bean" property="rollno"/></h1>


</body>
</html>
