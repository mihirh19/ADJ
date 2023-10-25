<%--
  Created by IntelliJ IDEA.
  User: Mihir
  Date: 03-10-2023
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bean page</title>
</head>
<body>

<jsp:useBean id="bean" class="com.example.bean.SetBeans" scope="session"> </jsp:useBean>
    <jsp:setProperty name="bean" property="*"/>

<jsp:forward page="details.jsp"/>
</body>
</html>
