<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 19/03/2023
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Registration</title>
  <style>
    .registration-container {
      margin: auto;
      width: 50%;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 10px;
      background-color: #f2f2f2;
    }

    form {
      display: flex;
      flex-direction: column;
      align-items: center;
    }

    h2 {
      margin-top: 0;
    }

    label {
      font-weight: bold;
    }

    input[type="text"], input[type="email"], input[type="password"], textarea, input[type="submit"] {
      margin: 5px 0;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      width: 100%;
      box-sizing: border-box;
    }

    textarea {
      resize: vertical;
    }

    input[type="submit"] {
      background-color: #4CAF50;
      color: white;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #45a049;
    }

    a {
      color: #4CAF50;
      text-decoration: none;
    }

    a:hover {
      text-decoration: underline;
    }

  </style>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="registration-container">
  <form method = "post" action="register">
    <h2>Registration</h2>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" placeholder="Enter your name">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" placeholder="Enter your email">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" placeholder="Choose a username">
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" placeholder="Choose a password">
    <label for="address">Address:</label>
    <textarea id="address" name="address" placeholder="Enter your address"></textarea>
    <input type="submit" value="Register">
  </form>
  <p>Already have an account? <a href="index.jsp">Log in here</a></p>
</div>
</body>
</html>
