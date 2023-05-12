package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.DAO.CartDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddToCartServlet", value = "/addCart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String p_name = request.getParameter("product_name");
        boolean check;
        try {
             check = CartDao.addToCart(username, p_name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String redirectUrl = "Homepage.jsp";
        String script;
        if(check){
            script = "<script>alert('Product successfully added.');window.location='" + redirectUrl + "'</script>";
        }else{
            script = "<script>alert('Product already in cart.');window.location='" + redirectUrl + "'</script>";
        }
        response.setContentType("text/html");
        response.getWriter().println(script);
    }
}
