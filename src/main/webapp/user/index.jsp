<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Page</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/style_index.css">
</head>
<body>
<div class="header">
    <jsp:include page="header.jsp" />
</div>

<div class="main-container">
    <div class="sidebar">
        <h2>Search</h2>
        <form action="${pageContext.request.contextPath}/search" method="get">
            <div class="form-group-inline">

                <input type="text" id="search" name="search" value="${param.search}" placeholder="Enter product name">
            </div>
            <div class="form-group">
                <button type="submit">Search</button>
            </div>
        </form>

        <h2>Filters</h2>
        <form action="${pageContext.request.contextPath}/filter" method="get">
            <label for="minPrice">Price</label>
            <div class="form-group-inline">
                <input type="number" id="minPrice" name="minPrice" min="0" value="${filterDto.minPrice}" placeholder="From">
                <input type="number" id="maxPrice" name="maxPrice" min="0" value="${filterDto.maxPrice}" placeholder="To">
            </div>

            <label for="category">Category</label>
            <div class="form-group-inline">
                <select id="category" name="categoryFilter">
                    <option value="" <c:if test="${filterDto.categoryFilter == null || filterDto.categoryFilter == ''}">selected</c:if>>All</option>
                    <c:forEach var="category" items="${categories}">
                        <option value="${category.name}" <c:if test="${filterDto.categoryFilter == category.name}">selected</c:if>>${category.name}</option>
                    </c:forEach>
                </select>
            </div>

            <label for="sort" >Sort by</label>
            <div class="form-group-inline">
                <select id="sort" name="sort">
                    <option value="">Default</option>
                    <option value="date" <c:if test="${param.sort == 'date'}">selected</c:if>>Date</option>
                    <option value="price_asc" <c:if test="${param.sort == 'price_asc'}">selected</c:if>>Price asc</option>
                    <option value="price_desc" <c:if test="${param.sort == 'price_desc'}">selected</c:if>>Price desc</option>
                    <option value="name" <c:if test="${param.sort == 'name'}">selected</c:if>>Name</option>
                </select>
            </div>

            <div class="form-group">
                <button type="submit">Apply Filters</button>
            </div>
        </form>
    </div>

    <div class="main-content">
        <c:if test="${products.isEmpty()}">
            <div class="no-products">
                <p>No products available</p>
            </div>
        </c:if>

        <div class="products-list">
            <c:forEach var="product" items="${products}">
                <div class="product-item">
                    <div class="product-image">
                        <a href="${pageContext.request.contextPath}/product/${product.id}">
                            <img src="${product.imageUrl}" alt="product image" >
                        </a>
                    </div>
                    <div class="product-details">
                        <a href="${pageContext.request.contextPath}/product/${product.id}" class="product-name">${product.name}</a>
                        <div class="product-price">${product.price}$</div>
                        <div class="product-quantity">Quantity: ${product.quantity}</div>
                        <div class="product-category">${product.category.name}</div>

                        <form action="${pageContext.request.contextPath}/cart/add" method="POST">
                            <input type="hidden" name="productId" value="${product.id}">
                            <div class="form-group-inline">
                                <label>Quantity:</label>
                                <input type="number" name="quantity" min="1" max="${product.quantity}" value="1">
                                <button type="submit">Add</button>
                            </div>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<div class="footer">
    <jsp:include page="footer.html" />
</div>
</body>
</html>
