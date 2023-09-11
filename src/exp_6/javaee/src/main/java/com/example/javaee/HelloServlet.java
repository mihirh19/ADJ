package com.example.javaee;

import java.io.*;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        try {
            String uname = request.getParameter("uname");
            String pwd = request.getParameter("pwd");
            String q = "select * from users where username=? and password=?";
            ResultSet rs = MakeCon.getRes(q,uname,pwd);
            rs.last();
            int n = rs.getRow();
            if (n<1){
                RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
                rd.forward(request,response);
            }else {
                session.setAttribute("uname",rs.getString(1));
                session.setAttribute("pwd",rs.getString(2));
RequestDispatcher rd = request.getRequestDispatcher("/details.jsp");
                rd.forward(request,response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}