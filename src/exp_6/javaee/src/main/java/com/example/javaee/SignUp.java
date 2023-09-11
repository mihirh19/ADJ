package com.example.javaee;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "signUp", value = "/signup")
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            String uname = req.getParameter("username");
            String pwd = req.getParameter("password");
            if (MakeCon.insert(uname,pwd)){
                RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
        rd.forward(req,resp);
            }else {
                RequestDispatcher rd = req.getRequestDispatcher("/signup.jsp");
                rd.forward(req,resp);
            }
    }catch (Exception e){
            e.printStackTrace();
        }finally {
              MakeCon.freeCon();

        }
    }
}
