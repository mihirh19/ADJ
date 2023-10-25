package com.example.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebFilter(filterName = "AllFilter", urlPatterns = "/submit")
public class AllFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest  req= (HttpServletRequest) servletRequest;
        HttpServletResponse res= (HttpServletResponse) servletResponse;

        int roll = Integer.parseInt(req.getParameter("roll"));

        if(roll > 0) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            res.sendRedirect("error.jsp");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
