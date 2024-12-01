<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
    <form action="/products" method="get">
        <label for="search">Search:</label>
        <input type="text" id="search" name="search" value="${param.search}" placeholder="Enter product name">
        <button type="submit">Search</button>
    </form>

    <form action="/products" method="get">
            <p>Filters:</p>

            <label for="category">Category:</label>
            <select id="category" name="category">
                <option value="">All</option>
                <c:forEach var="category" items="${categories}">
                    <option value="${category}"
                            <c:if test="${param.category == category}">selected</c:if>>
                            ${category}
                    </option>
                </c:forEach>
            </select>
            <br>
            <label for="minPrice">Min Price:</label>
            <input type="number" id="minPrice" name="minPrice" value="${param.minPrice}" step="0.01">
            <br>
            <label for="maxPrice">Max Price:</label>
            <input type="number" id="maxPrice" name="maxPrice" value="${param.maxPrice}" step="0.01">
            <br>
            <button type="submit">Apply Filters</button>
    </form>

    <hr>
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