<%--
  Created by IntelliJ IDEA.
  User: Mihir
  Date: 01-10-2023
  Time: 07:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success</title>
</head>
<body>
<%
    String user = null;
    if (session.getAttribute("username") == null) {
        response.sendRedirect("/index.jsp");
    }
    else {
        user = session.getAttribute("username").toString();
    }

    String userName = null;
    String sesstionId = null;
    Cookie [] cookies = request.getCookies();

    if (cookies != null){
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("username")){
                userName = cookie.getValue();
            }
            if (cookie.getName().equals("JSESSIONID")){
                sesstionId = cookie.getValue();
            }
        }
    }

%>
<h3>Hi <%=userName%> Login, Successful. Your Session id is <%=sesstionId%>></h3>

<br>
<form action="logout-servlet" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>
