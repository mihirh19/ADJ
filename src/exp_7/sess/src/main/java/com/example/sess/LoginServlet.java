package com.example.sess;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
        private final String username = "Mihir";
        private final String password = "Mihir";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        if (user.equals(username) && pass.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", user);
            session.setMaxInactiveInterval(5*60);
            Cookie userName = new Cookie("username", user);
            userName.setMaxAge(5*60);
            resp.addCookie(userName);
            resp.sendRedirect("loginSuccess.jsp");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.forward(req, resp);


        }
    }
}
