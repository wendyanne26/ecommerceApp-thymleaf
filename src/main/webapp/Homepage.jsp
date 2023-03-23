<%@ page import="com.example.ecommerceapp.DAO.ProductDao" %>
<%@ page import="com.example.ecommerceapp.Models.Product" %>
<%@ page import="java.util.List" %>
<% ProductDao pd = new ProductDao();
    List<Product> products = pd.listOfProducts();
%>
<!DOCTYPE html>
<html>
<head>
    <title>E-commerce Dashboard</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style>
        header {
            background-color: #333;
            color: #fff;
            padding: 1em;
        }

        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        nav li {
            display: inline-block;
            margin-right: 1em;
        }

        nav a {
            color: #fff;
            text-decoration: none;
        }

        .products {
            margin: 2em;
        }

        .products h2 {
            font-size: 2em;
            margin-bottom: 1em;
        }

        .products ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        .products li {
            display: inline-block;
            margin-right: 2em;
            vertical-align: top;
            width: 30%;
        }

        .products img {
            width: 100%;
        }

        .products p {
            font-size: 1.2em;
        }

        .add-to-wishlist {
            background-color: #1abc9c;
            border: none;
            color: #fff;
            padding: 1em;
            margin-right: 0.5em;
            cursor: pointer;
        }

        .add-to-cart {
            background-color: #3498db;
            border: none;
            color: #fff;
            padding: 1em;
            margin-right: 0.5em;
            cursor: pointer;
        }

    </style>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="#">My Cart</a></li>
            <li><a href="#">Search Product</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </nav>
</header>

<section class="products">
    <h2>Products</h2>
    <ul>
        <%if(!products.isEmpty()){
            for(Product p : products){

        %>
        <li>
            <h3><%=p.getProductName()%></h3>
            <img src="Images/<%=p.getProductImage()%>" alt="Product 1">
            <p>$<%=p.getPrice()%></p>
            <button class="add-to-wishlist">Add to Wishlist</button>
            <button class="add-to-cart">Add to Cart</button>
        </li>
       <%
           }
        }
       %>
    </ul>
</section>

</body>
</html>
