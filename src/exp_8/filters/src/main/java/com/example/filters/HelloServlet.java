package com.example.filters;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "submit", value = "/submit")
public class HelloServlet extends HttpServlet {


    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        int a = Integer.parseInt(request.getParameter("roll"));
        String name =  request.getParameter("sname");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Roll No: " + a + "</h1>");
        out.println("<h1>Name: " + name + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}