package com.example.ecommerceapp.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        if(request.getSession().getAttribute("username") != null){
            request.getSession().removeAttribute("username");
            response.sendRedirect("index.jsp");
        }else{
            response.sendRedirect("Registration.jsp");
        }
    }
}
