<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Login</title>

<style>
body { font-family: Arial; background:#667eea; }
.box {
    width:300px;
    margin:100px auto;
    background:white;
    padding:20px;
    border-radius:10px;
    text-align:center;
}
input {
    width:90%;
    padding:10px;
    margin:8px;
}
button {
    padding:10px;
    width:100%;
    background:#5a67d8;
    color:white;
    border:none;
}
</style>

</head>
<body>

<h1 style="text-align:center;color:white;">Online Food Ordering System</h1>
<hr>

<div class="box">
<h2>Login</h2>

<form action="/OnlineDelivery_Backend/LoginServlet" method="post">
    <input type="email" name="email" placeholder="Email" required><br>
    <input type="password" name="password" placeholder="Password" required><br>
    <button type="submit">Login</button>
</form>

</div>

</body>
</html>