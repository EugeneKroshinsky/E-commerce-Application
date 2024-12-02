<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>Product Details</h1>

    <p><b>Name:</b> ${product.name}</p>
    <p><b>Description:</b> ${product.description}</p>
    <p><b>Price:</b> ${product.price}</p>
    <p><b>Quantity:</b> ${product.quantity}</p>
    <p><b>Category:</b> ${product.category.name}</p>
    <p><b>Image:</b> <img src="${product.imageUrl}" alt="${product.name}" /></p>

    <form action="${pageContext.request.contextPath}/cart" method="POST">
        <input type="hidden" name="action" value="add">
        <input type="hidden" name="productId" value="${product.id}">
        <label>Quantity:</label>
        <input type="number" name="quantity" min="1" value="1">
        <button type="submit">Add to Cart</button>
    </form>

    <a href="javascript:history.back()">Back to Product List</a>
<jsp:include page="footer.html" />
</body>
</html>
