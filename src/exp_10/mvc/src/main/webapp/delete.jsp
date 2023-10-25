<%--
  Created by IntelliJ IDEA.
  User: Mihir
  Date: 04-10-2023
  Time: 10:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sql" uri="jakarta.tags.sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete</title>
</head>
<body>
<sql:setDataSource var="db" driver="org.postgresql.Driver"
                   url="jdbc:postgresql://localhost:5432/adj"
                   user="postgres"  password="postgres"/>

<sql:update dataSource="${db}" var="rs">
    DELETE FROM DEMO
    WHERE id = ?
    <sql:param value="${param.ID}"/>
</sql:update>

<jsp:forward page="display.jsp"/>


</body>
</html>
