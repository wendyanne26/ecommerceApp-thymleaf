package com.example.ecommerceapp.DAO;

import com.example.ecommerceapp.Models.User;
import com.example.ecommerceapp.connection.Connectivity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
   public static Connection con = Connectivity.getdBCon();

    public static List<String> getUsernames() throws SQLException {
        List<String> usernames = new ArrayList<>();
        String query = "SELECT * FROM users";
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            usernames.add(rs.getString("username"));
        }
        stmt.close();
        return usernames;
    }

    public boolean  registerUsers(User user) throws SQLException {
        boolean notExists;
        String query = "INSERT INTO users (name, e_mail, username, password, address) VALUES (?,?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getUserName());
        statement.setString(4, user.getPassword());
        statement.setString(5, user.getAddress());

        if(!getUsernames().contains(user.getUserName())){
            notExists = true;
            statement.executeUpdate();
            statement.close();
        }else{
            notExists = false;
        }
        return notExists;
    }

    public boolean loginUser(String username, String password) throws SQLException {
        boolean correct = false;
        String query = "SELECT user_id FROM users WHERE username = ? AND password = ?";
        PreparedStatement stat1 = con.prepareStatement(query);
        stat1.setString(1, username);
        stat1.setString(2, password);

        ResultSet resultSet = stat1.executeQuery();
        while (resultSet.next()){
            correct = true;
        }
        return correct;
    }
    public boolean checkAdmin(String username){
        if(username.equals("admin")){
            return true;
        }
        return false;
    }
}
