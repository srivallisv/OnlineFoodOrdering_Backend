<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Register</title>
</head>
<body style="font-family:Arial; text-align:center;">

<h1>Online Food Ordering System</h1>
<hr>

<h2>Register</h2>

<form action="RegisterServlet" method="post">

    Name: <input type="text" name="name" required><br><br>
    Email: <input type="text" name="email" required><br><br>
    Password: <input type="password" name="password" required><br><br>

    <button type="submit">Register</button>

</form>

</body>
</html>