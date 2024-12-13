<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Details</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/style_product.css">
</head>
<body>
<div class="header">
    <jsp:include page="header.jsp" />
</div>

<div class="product-container">
    <h1 class="page-title">Product Details</h1>

    <div class="product-details">
        <div class="product-image">
            <img src="${product.imageUrl}" alt="${product.name}" />
        </div>
        <div class="product-info">
            <p><strong>Name:</strong> ${product.name}</p>
            <p><strong>Description:</strong> ${product.description}</p>
            <p><strong>Price:</strong> ${product.price}$</p>
            <p><strong>Quantity Available:</strong> ${product.quantity}</p>
            <p><strong>Category:</strong> ${product.category.name}</p>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/cart/add" method="POST" class="add-to-cart-form">
        <input type="hidden" name="productId" value="${product.id}">
        <label for="quantity">Quantity:</label>
        <input type="number" name="quantity" id="quantity" min="1" max="${product.quantity}" value="1" required>
        <button type="submit" class="add-to-cart-button">Add to Cart</button>
    </form>

    <div class="back-link">
        <a href="javascript:history.back()" class="back-button">Back to Product List</a>
    </div>
</div>

<div class="footer">
    <jsp:include page="footer.html" />
</div>
</body>
</html>
