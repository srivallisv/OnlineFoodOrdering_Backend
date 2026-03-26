<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Feedback</title>
</head>
<body style="font-family:Arial; text-align:center;">

<h1>Online Food Ordering System</h1>
<hr>

<h2>Feedback</h2>

<form action="FeedbackServlet" method="post">

    User ID: <input type="text" name="userId" required><br><br>
    Rating: <input type="number" name="rating" required><br><br>
    Comments: <textarea name="comments" required></textarea><br><br>

    <button type="submit">Submit</button>

</form>

</body>
</html>