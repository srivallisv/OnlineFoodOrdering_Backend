<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Home</title>

<style>
body { font-family: Arial; background:#f8f8f8; }
.header {
    background:#e23744;
    color:white;
    padding:15px;
    text-align:center;
}
.container {
    display:flex;
    justify-content:center;
    flex-wrap:wrap;
}
.card {
    background:white;
    width:250px;
    margin:15px;
    padding:15px;
    border-radius:10px;
    box-shadow:0 0 10px gray;
    text-align:center;
}
a {
    text-decoration:none;
    color:white;
}
button {
    background:#e23744;
    color:white;
    border:none;
    padding:8px;
    width:100%;
    margin-top:10px;
}
</style>
</head>

<body>

<div class="header">
<h1>Online Food Ordering System 🍽️</h1>
</div>

<div class="container">

<div class="card">
<h3>Pizza Hub</h3>
<p>Italian, Fast Food</p>
<a href="menu.jsp?res=1"><button>View Menu</button></a>
</div>

<div class="card">
<h3>Burger King</h3>
<p>Burgers, Snacks</p>
<a href="menu.jsp?res=2"><button>View Menu</button></a>
</div>

<div class="card">
<h3>Biryani House</h3>
<p>Indian, Biryani</p>
<a href="menu.jsp?res=3"><button>View Menu</button></a>
</div>

<div class="card">
<h3>Domino's Pizza</h3>
<p>Pizzas, Desserts</p>
<a href="menu.jsp?res=4"><button>View Menu</button></a>
</div>

<div class="card">
<h3>KFC</h3>
<p>Fried Chicken, Fast Food</p>
<a href="menu.jsp?res=5"><button>View Menu</button></a>
</div>

<div class="card">
<h3>Udupi Cafe</h3>
<p>South Indian, Veg</p>
<a href="menu.jsp?res=6"><button>View Menu</button></a>
</div>

<div class="card">
<h3>Chinese Wok</h3>
<p>Chinese, Noodles</p>
<a href="menu.jsp?res=7"><button>View Menu</button></a>
</div>

<div class="card">
<h3>BBQ Nation</h3>
<p>Grill, Buffet</p>
<a href="menu.jsp?res=8"><button>View Menu</button></a>
</div>

</div>

</body>
</html>