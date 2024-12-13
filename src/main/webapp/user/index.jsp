<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <form action="${pageContext.request.contextPath}/search" method="get">
        <label for="search">Search:</label>
        <input type="text" id="search" name="search" value="${param.search}" placeholder="Enter productEntity name">
        <button type="submit">Search</button>
    </form>
    <hr>
    <form action="${pageContext.request.contextPath}/filter" method="get">
            <p>Filters:</p>
            <label for="category">Category:</label>
            <select id="category" name="categoryFilter">
                <option value="" <c:if test="${filterDto.categoryFilter == null || filterDto.categoryFilter == ''}">selected</c:if>>All</option>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.name}"
                            <c:if test="${filterDto.categoryFilter == category.name}">selected</c:if>>
                            ${category.name}
                    </option>
                </c:forEach>
            </select>

            <br>
            <label for="minPrice">Min Price:</label>
            <input type="number" id="minPrice" name="minPrice" min="0" value="${filterDto.minPrice}">
            <br>
            <label for="maxPrice">Max Price:</label>
            <input type="number" id="maxPrice" name="maxPrice" min="0" value="${filterDto.maxPrice}">
            <br>
        <label for="sort">Sort by:</label>
        <select id="sort" name="sort">
            <option value="">Default</option>
            <option value="date" <c:if test="${param.sort == 'date'}">selected</c:if>>Date</option>
            <option value="price_asc" <c:if test="${param.sort == 'price_asc'}">selected</c:if>>Price asc</option>
            <option value="price_desc" <c:if test="${param.sort == 'price_desc'}">selected</c:if>>Price desc</option>
            <option value="name" <c:if test="${param.sort == 'name'}">selected</c:if>>Name</option>
        </select>
        <br>
            <button type="submit">Apply Filters</button>
    </form>

    <hr>
    <h1>Products</h1>
    <c:if test="${products.isEmpty()}">
        <p>No productEntities</p>
    </c:if>
    <c:forEach var="product" items="${products}">
        <hr>
        <a href="${pageContext.request.contextPath}/product/${product.id}">Name: ${product.name}</a>
        <p>Description: ${product.description}</p>
        <p>Price: ${product.price}</p>
        <p>Quantity: ${product.quantity}</p>
        <p>Category: ${product.category.name}</p>
        <form action="${pageContext.request.contextPath}/cart/add" method="POST">
            <input type="hidden" name="productId" value="${product.id}">
            <label>Quantity:</label>
            <input type="number" name="quantity" min="1" max="${product.quantity}" value="1">
            <button type="submit">Add to Cart</button>
        </form>
    </c:forEach>

    <jsp:include page="footer.html" />
</body>
</html>