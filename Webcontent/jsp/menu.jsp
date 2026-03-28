<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<title>Menu</title>

<style>
body { font-family: Arial; background:#f4f4f4; }
.header {
    background:#e23744;
    color:white;
    padding:15px;
    text-align:center;
}
.container { width:60%; margin:auto; }
.card {
    background:white;
    padding:15px;
    margin:10px 0;
    border-radius:8px;
    display:flex;
    justify-content:space-between;
}
button {
    background:#e23744;
    color:white;
    border:none;
    padding:5px 10px;
}
a { text-decoration:none; }
</style>
</head>

<body>

<div class="header">
<h1>Menu 🍽️</h1>
</div>

<div class="container">

<%
String res = request.getParameter("res");

class Item {
    String name; int price;
    Item(String n, int p){ name=n; price=p; }
}

List<Item> items = new ArrayList<>();

// RESTAURANT MENUS

if("1".equals(res)){
    items = Arrays.asList(
        new Item("Margherita",200),
        new Item("Farmhouse",300),
        new Item("Peppy Paneer",350),
        new Item("Veg Extravaganza",400)
    );
}
else if("2".equals(res)){
    items = Arrays.asList(
        new Item("Veg Burger",120),
        new Item("Cheese Burger",150),
        new Item("Paneer Burger",180),
        new Item("Fries",100)
    );
}
else if("3".equals(res)){
    items = Arrays.asList(
        new Item("Veg Biryani",180),
        new Item("Paneer Biryani",220),
        new Item("Curd Rice",90),
        new Item("Mushroom Biryani",200)
    );
}
else if("4".equals(res)){
    items = Arrays.asList(
        new Item("Cheese Burst",350),
        new Item("Pepperoni",400),
        new Item("Garlic Bread",150),
        new Item("Lava Cake",120)
    );
}
else if("5".equals(res)){
    items = Arrays.asList(
        new Item("Chicken Bucket",450),
        new Item("Zinger Burger",200),
        new Item("Popcorn Chicken",250),
        new Item("Fries",120)
    );
}
else if("6".equals(res)){
    items = Arrays.asList(
        new Item("Masala Dosa",80),
        new Item("Idli Vada",60),
        new Item("Pongal",90),
        new Item("Filter Coffee",40)
    );
}
else if("7".equals(res)){
    items = Arrays.asList(
        new Item("Hakka Noodles",150),
        new Item("Fried Rice",140),
        new Item("Manchurian",180),
        new Item("Spring Rolls",120)
    );
}
else if("8".equals(res)){
    items = Arrays.asList(
        new Item("Veg Grill",300),
        new Item("Paneer Tikka",250),
        new Item("Buffet Meal",500),
        new Item("Dessert Combo",200)
    );
}

// DISPLAY ITEMS
for(Item i : items){
%>

<div class="card">
<span><%= i.name %> - ₹<%= i.price %></span>

<form action="AddToCartServlet" method="post">
    <input type="hidden" name="itemName" value="<%= i.name %>">
    <input type="hidden" name="price" value="<%= i.price %>">
    <input type="hidden" name="res" value="<%= res %>">
    <button>Add</button>
</form>

</div>

<%
}
%>

</div>

<div style="text-align:center; margin-top:20px;">
<a href="cart.jsp">Go to Cart 🛒</a>
</div>

</body>
</html>