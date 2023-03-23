package com.example.ecommerceapp.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String email;
    private String userName;
    private String password;
    private String address;
}
