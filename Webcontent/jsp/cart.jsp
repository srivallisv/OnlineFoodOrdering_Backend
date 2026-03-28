<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<title>Cart</title>
</head>

<body style="font-family:Arial; text-align:center;">

<h1>Your Cart</h1>
<hr>

<%
List<String> cart = (List<String>) session.getAttribute("cart");

if(cart != null && !cart.isEmpty()){
    for(String item : cart){
%>

<p><%= item %></p>

<%
    }
} else {
%>
<p>Cart is empty</p>
<%
}
%>

<br>
<a href="home.jsp">Back to Home</a>

</body>
</html>