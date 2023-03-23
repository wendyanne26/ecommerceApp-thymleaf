package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.DAO.ProductDao;
import com.example.ecommerceapp.Models.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "addProductToStoreServlet", value = "/add-product")
public class AddProductToStoreServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_name = request.getParameter("product_name");
        String product_category = request.getParameter("product_category");
        int product_quantity = Integer.parseInt(request.getParameter("product_quantity"));
        double product_price = Double.parseDouble(request.getParameter("product_price"));
        String product_img = request.getParameter("product_img");


        HttpSession session = request.getSession();
        ProductDao productDao = new ProductDao();

        Product product = new Product(product_name, product_category, product_quantity, product_price, product_img);
        boolean check;
        try {
            check = productDao.addProduct(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (check){
            response.sendRedirect("adminHomePage.jsp");
        }else{
            String redirectUrl = "adminHomePage.jsp";
            String script = "<script>alert('Operation unsuccessful.');window.location='" + redirectUrl + "'</script>";
            response.setContentType("text/html");
            response.getWriter().println(script);
        }

    }

}
