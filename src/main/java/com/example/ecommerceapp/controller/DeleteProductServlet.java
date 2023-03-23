package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.DAO.ProductDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteProductServlet", value = "/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String product_name = request.getParameter("product_name");

        ProductDao productDao = new ProductDao();

        boolean check;
        try {
           check =  productDao.deleteProduct(product_name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(check){
            response.sendRedirect("adminHomePage.jsp");
        }else{
            String redirectUrl = "adminHomePage.jsp";
            String script = "<script>alert('Operation unsuccessful.');window.location='" + redirectUrl + "'</script>";
            response.setContentType("text/html");
            response.getWriter().println(script);
        }
    }
}
