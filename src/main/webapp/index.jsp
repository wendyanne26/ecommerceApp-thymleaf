<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style>
        .login-container {
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

        input[type="text"], input[type="password"], input[type="submit"] {
            margin: 5px 0;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 100%;
            box-sizing: border-box;
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
</head>
<body>
<div class="login-container">
    <form method="post" action="IndexServlet">
        <h2>Login</h2>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" placeholder="Enter username">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="Enter password">
        <input type="submit" value="Login">
    </form>
    <p>Don't have an account? <a href="Registration.jsp">Sign up here</a></p>
</div>
</body>
</html>
