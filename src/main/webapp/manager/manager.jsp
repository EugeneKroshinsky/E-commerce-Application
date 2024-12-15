<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Admin Panel</title>
</head>
<body>
<div class="header">
    <jsp:include page="/user/header.jsp" />
</div>

<h1>Admin Panel</h1>
<ul>
    <li><a href="${pageContext.request.contextPath}/manager/order">Manage Orders</a></li>
    <li><a href="${pageContext.request.contextPath}/manager/product">Manage Products</a></li>
</ul>
</body>
</html>
