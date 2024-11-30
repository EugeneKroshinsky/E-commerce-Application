<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
    <h1>Products</h1>
    <c:forEach var="product" items="${products}">
        <hr>
        <b>Id: ${product.id}</b> <br>
        <b>Name: ${product.name}</b>
        <p>Description: ${product.description}</p>
        <p>Price: ${product.price}</p>
        <p>Quantity: ${product.quantity}</p>
        <p>Category: ${product.category}</p>
    </c:forEach>
</body>
</html>