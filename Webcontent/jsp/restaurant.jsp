<%@ page import="model.Restaurant" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<title>Restaurant</title>

<style>
body { font-family: Arial; background:#f4f4f4; }
.box {
    width:400px;
    margin:60px auto;
    background:white;
    padding:20px;
    border-radius:10px;
}
input { width:100%; padding:8px; margin:5px 0; }
button {
    width:100%;
    padding:10px;
    background:green;
    color:white;
}
.nav {
    text-align:center;
    margin-top:10px;
}
</style>

</head>
<body>

<h1 style="text-align:center;">Online Food Ordering System</h1>
<hr>

<div class="nav">
<a href="login.jsp">Home</a>
</div>

<div class="box">

<h2>Restaurant Details</h2>

<%
Restaurant r = (Restaurant) request.getAttribute("restaurant");
if (r != null) {
%>

ID: <%= r.getId() %><br>
Name: <%= r.getName() %><br>
Location: <%= r.getLocation() %><br><br>

<form action="order" method="get">
    <input type="hidden" name="restaurantId" value="<%= r.getId() %>">

    User ID: <input type="text" name="userId"><br>
    Order ID: <input type="text" name="id"><br>
    Total: <input type="text" name="total"><br>

    <button type="submit">Place Order</button>
</form>

<%
} else {
%>
<h3>No restaurant found</h3>
<%
}
%>

</div>

</body>
</html>