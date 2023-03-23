package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.DAO.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/IndexServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        UserDao userDao = new UserDao();
        boolean isAdmin = userDao.checkAdmin(username);

        try {
            if (isAdmin && userDao.loginUser(username, password)) {
                // Redirect admin to admin dashboard
                session.setAttribute("username", username);
                response.sendRedirect("adminHomePage.jsp");
            } else if (userDao.loginUser(username, password)) {
                // Redirect users to homepage
                session.setAttribute("username", username);
                response.sendRedirect("Homepage.jsp");
            } else {
                // Prompt user to input correct details
                String redirectUrl = "index.jsp";
                String script = "<script>alert('Username or password incorrect.');window.location='" + redirectUrl + "'</script>";
                response.setContentType("text/html");
                response.getWriter().println(script);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
