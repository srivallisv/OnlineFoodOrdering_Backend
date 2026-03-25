<%@ page import="java.util.List" %>
<%@ page import="model.Order" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<title>Orders</title>

<style>
body { font-family: Arial; background:#f4f4f4; }
.container { width:70%; margin:40px auto; }
.card {
    background:white;
    padding:15px;
    margin:10px 0;
    border-radius:8px;
}
.nav {
    text-align:center;
    margin-bottom:20px;
}
</style>

</head>
<body>

<h1 style="text-align:center;">Online Food Ordering System</h1>
<hr>

<div class="nav">
<a href="login.jsp">Home</a>
</div>

<div class="container">
<h2>Your Orders</h2>

<%
List<Order> orders = (List<Order>) request.getAttribute("orders");

if (orders != null && !orders.isEmpty()) {
    for (Order o : orders) {
%>

<div class="card">
Order ID: <%= o.getId() %><br>
User ID: <%= o.getUserId() %><br>
Restaurant ID: <%= o.getRestaurantId() %><br>
Date: <%= o.getOrderDate() %><br>
Total: Rs. <%= o.getTotal() %>
</div>

<%
    }
} else {
%>
<h3>No orders found</h3>
<%
}
%>

</div>

</body>
</html>