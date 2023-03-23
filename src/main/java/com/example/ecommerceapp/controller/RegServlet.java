package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.DAO.UserDao;
import com.example.ecommerceapp.Models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegServlet", value = "/register")
public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");


        UserDao userDao = new UserDao();
        User user = new User(name, email, userName, password, address);

        boolean check;
        try {
            check = userDao.registerUsers(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (check) {
            String redirectUrl = "index.jsp";
            String script = "<script>alert('Registration successful.');window.location='" + redirectUrl + "'</script>";
            response.setContentType("text/html");
            response.getWriter().println(script);
        } else {
            String redirectUrl = "Registration.jsp";
            String script = "<script>alert('Username already exists.');window.location='" + redirectUrl + "'</script>";
            response.setContentType("text/html");
            response.getWriter().println(script);
        }
    }
}
