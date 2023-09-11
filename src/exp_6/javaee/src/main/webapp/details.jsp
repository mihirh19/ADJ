<%--
  Created by IntelliJ IDEA.
  User: Mihir
  Date: 11-09-2023
  Time: 07:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
    <div>
        <p>
            <%
                HttpSession ses = request.getSession(false);
                PrintWriter put = response.getWriter();
                if(ses.getAttribute("uname") == null || ses.getAttribute("pwd") == null){
                    RequestDispatcher rd1 = request.getRequestDispatcher("/hello-servlet");
                    rd1.forward(request,response);

                }
                String mes = ses.getAttribute("uname").toString() + " " + ses.getAttribute("pwd").toString();
                put.println(mes);
    %>
        </p>
    </div>
</body>
</html>
