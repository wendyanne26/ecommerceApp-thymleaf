package com.example.ecommerceapp.DAO;

import com.example.ecommerceapp.Models.Product;
import com.example.ecommerceapp.connection.Connectivity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    PreparedStatement statement;
    public static Connection con = Connectivity.getdBCon();

    public List<Product> listOfProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        Product p;
        String query = "SELECT * FROM store_products";
        statement = con.prepareStatement(query);
        ResultSet sets = statement.executeQuery();
        while(sets.next()){
            p = new Product(sets.getString("product_name"), sets.getString("product_category"), sets.getInt("product_quantity"), sets.getDouble("product_price"), sets.getString("product_img"));
            products.add(p);
        }
        return products;
    }

    public boolean addProduct(Product product) throws SQLException {
        String productToAdd = "INSERT INTO store_products(product_name, product_category, product_quantity, product_price, product_img) VALUES(?,?,?,?,?)";
        boolean ok = false;
        try {
            statement = con.prepareStatement(productToAdd);
            statement.setString(1, product.getProductName());
            statement.setString(2, product.getProductCategory());
            statement.setInt(3, product.getQuantity());
            statement.setDouble(4, product.getPrice());
            statement.setString(5, product.getProductImage());
            ok = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return ok;
    }

    public boolean deleteProduct(String name) throws SQLException {
        boolean deleted;
        String productToDelete = "DELETE FROM store_products WHERE product_name = ?";
        statement = con.prepareStatement(productToDelete);
        statement.setString(1, name);
        deleted = statement.executeUpdate() > 0;
        return deleted;
    }

    public static void main(String[] args) throws SQLException {
        ProductDao dao = new ProductDao();
        Product p = new Product("3-in-1 bag", "Female", 5, 30.00, "3-in1 designer.png");
        dao.addProduct(p);


        List<Product> products = dao.listOfProducts();
        for(Product u : products){
            System.out.println(u);
        }
    }

}
