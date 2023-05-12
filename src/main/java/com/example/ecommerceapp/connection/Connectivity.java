package com.example.ecommerceapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectivity {
    private static final Connection dBCon;
    private static String userName = "root";
    private static String password = "wendy2580";
    private static String url = "jdbc:mysql://localhost:3306/aplication";
    private static String className = "com.mysql.cj.jdbc.Driver";

static{
    try{
        Class.forName(className);
        dBCon = DriverManager.getConnection(url, userName, password);
    } catch (ClassNotFoundException | SQLException e) {
        throw new RuntimeException(e);
    }
}

    public static Connection getdBCon() {
        return dBCon;
    }
}
