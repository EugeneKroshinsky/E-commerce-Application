<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h1>Product Details</h1>

    <p><b>Name:</b> ${product.name}</p>
    <p><b>Description:</b> ${product.description}</p>
    <p><b>Price:</b> ${product.price}</p>
    <p><b>Quantity:</b> ${product.quantity}</p>
    <p><b>Category:</b> ${product.category}</p>
    <p><b>Image:</b> <img src="${product.imageUrl}" alt="${product.name}" /></p>
    <a href="javascript:history.back()">Back to Product List</a>
</body>
</html>
