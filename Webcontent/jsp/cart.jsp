<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Cart</title>
</head>
<body style="font-family:Arial; text-align:center;">

<h1>Online Food Ordering System</h1>
<hr>

<h2>Cart</h2>

<form action="CartServlet" method="post">

    Item Name: <input type="text" name="itemName" required><br><br>
    Quantity: <input type="number" name="quantity" required><br><br>
    Price: <input type="text" name="price" required><br><br>

    <button type="submit">Proceed</button>

</form>

</body>
</html>