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
    <title>Display</title>
</head>
<body>
<sql:setDataSource var="db" driver="org.postgresql.Driver"
                   url="jdbc:postgresql://localhost:5432/adj"
                   user="postgres"  password="postgres"/>

<sql:query dataSource="${db}" var="rs">
    SELECT * from demo
</sql:query>

<table border="2" width="100%">
    <tr>
        <th>Student ID</th>
        <th>First Name</th>
    </tr>
    <c:forEach var="table" items="${rs.rows}">
        <tr>
            <td><c:out value="${table.id}"/></td>
            <td><c:out value="${table.name}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
