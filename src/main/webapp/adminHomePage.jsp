<%@ page import="com.example.ecommerceapp.DAO.ProductDao" %>
<%@ page import="com.example.ecommerceapp.Models.Product" %>
<%@ page import="java.util.List" %>
<% ProductDao pd = new ProductDao();
  List<Product> products = pd.listOfProducts();
%>
<!DOCTYPE html>
<html>
<head>
  <title>E-commerce Admin Dashboard</title>
  <link rel="stylesheet" type="text/css" href="style.css">
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }
    body {
      font-family: Arial, sans-serif;
      font-size: 16px;
    }

    header {
      background-color: #333;
      color: #fff;
      padding: 1rem;
    }

    nav ul {
      list-style: none;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: flex-end;
    }

    nav ul li {
      margin: 0 1rem;
    }

    nav ul li a {
      color: #fff;
      text-decoration: none;
    }

    section {
      padding: 2rem;
    }

    .view-products table {
      border-collapse: collapse;
      width: 100%;
    }

    .view-products th {
      background-color: #eee;
      border: 1px solid #ddd;
      padding: 0.5rem;
      text-align: left;
    }

    .view-products td {
      border: 1px solid #ddd;
      padding: 0.5rem;
    }

    .view-products button {
      background-color: #333;
      color: #fff;
      border: none;
      padding: 0.5rem;
      margin-right: 0.5rem;
      cursor: pointer;
    }

    .add-product form label {
      display: block;
      margin-bottom: 0.5rem;
    }

    .add-product form input {
      padding: 0.5rem;
      border-radius: 5px;
      border: 1px solid #ddd;
      margin-bottom: 1rem;
    }

    .add-product form button {
      background-color: #333;
      color: #fff;
      border: none;
      padding: 0.5rem;
      cursor: pointer;
    }
    .delete-product form label {
      display: block;
      margin-bottom: 0.5rem;
    }

    .delete-product form input {
      padding: 0.5rem;
      border-radius: 5px;
      border: 1px solid #ddd;
      margin-bottom: 1rem;
    }

    .delete-product form button {
      background-color: #333;
      color: #fff;
      border: none;
      padding: 0.5rem;
      cursor: pointer;
    }

    .view-orders ul {
      list-style: none;
      margin: 0;
      padding: 0;
    }

    .view-orders li {
      border: 1px solid #ddd;
      padding: 1rem;
      margin-bottom: 1rem;
    }

    .view-orders li h3 {
      margin-bottom: 0.5rem;
    }

  </style>
</head>
<body>
<header>
  <nav>
    <ul>
      <li><a href="#">View Products</a></li>
      <li><a href="index.jsp">Log Out</a></li>
      <li><a href="#">View Orders</a></li>
    </ul>
  </nav>
</header>

<section class="view-products">
  <h2>View Products</h2>
  <table>
    <tr>
      <th>Product Name</th>
      <th>Price</th>
      <th>Quantity</th>
    </tr>
    <% if(!products.isEmpty()){
          for(Product p : products){
    %>
    <tr>
      <td><%=p.getProductName()%></td>
      <td>$<%=p.getPrice()%></td>
      <td><%=p.getQuantity()%></td>
    </tr>
    <%
          }
        }
%>
  </table>
</section>

<section class="add-product">
  <h2>Add Product</h2>
  <form method="post" action="add-product">
    <label for="product_name">Product Name:</label>
    <input type="text" id="product_name" name="product_name" required><br>

    <label for="product_price">Price:</label>
    <input type="number" id="product_price" name="product_price" required><br>

    <label for="product_quantity">Quantity:</label>
    <input type="number" id="product_quantity" name="product_quantity" required><br>

    <label for="product_category">Category:</label>
    <input type="text" id="product_category" name="product_category" required><br>

    <label for="product_img">Image:</label>
    <input type="text" id="product_img" name="product_img" ><br>

    <button type="submit">Add Product</button>
  </form>
</section>

<section class="delete-product">
  <h2>Delete Product</h2>
  <form method="post" action="deleteProduct">
    <label for="name">Product Name:</label>
    <input type="text" id="name" name="product_name" required><br>
    <button type="submit">Delete Product</button>
  </form>
</section>

<section class="view-orders">
  <h2>View Orders</h2>
  <ul>
    <li>
      <h3>Order #1</h3>
      <p>Product: Product 1</p>
      <p>Quantity: 5</p>
      <p>Total Price: $50.00</p>
    </li>
    <li>
      <h3>Order #2</h3>
      <p>Product: Product 2</p>
      <p>Quantity: 2</p>
      <p>Total Price: $30.00</p>
    </li>
    <li>
      <h3>Order #3</h3>
      <p>Product: Product 3</p>
      <p>Quantity: 1</p>
      <p>Total Price: $20.00</p>
    </li>
  </ul>
</section>
</body>
</html>