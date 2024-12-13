<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/style_cart.css">
</head>
<body>
<div class="header">
    <jsp:include page="header.jsp" />
</div>

<div class="main-container">
    <c:if test="${cart.isEmpty()}">
        <div class="empty-cart-message">
            <p>Your cart is empty</p>
        </div>
    </c:if>

    <c:if test="${not empty errorMessage}">
        <div class="error-message">
            <p>${errorMessage}</p>
        </div>
    </c:if>

    <div class="cart-items">
        <c:forEach var="item" items="${cart}">
            <div class="cart-item">
                <div class="item-details">
                    <div class="href_to_product">
                        <a href="${pageContext.request.contextPath}/product/${item.product.id}">${item.product.name}</a>
                    </div>
                    <p>${item.product.description}</p>
                    <p><strong></strong>${item.product.price}$</p>
                    <p><strong>Quantity: </strong>${item.quantity}</p>
                    <p><strong>Total Price: </strong>${item.quantity * item.product.price}$</p>
                </div>
                <form action="${pageContext.request.contextPath}/cart/delete" method="POST" class="delete-form">
                    <input type="hidden" name="productId" value="${item.product.id}">
                    <button type="submit" class="delete-button">Delete</button>
                </form>
            </div>
            <hr>
        </c:forEach>
    </div>

    <div class="total-price">
        <p><strong>Total: </strong>${cart.stream().map(ct -> ct.product.price * ct.quantity).sum()} USD</p>
    </div>

    <div class="cart-actions">
        <a href="${pageContext.request.contextPath}/order" class="order-button">Order</a>
        <a href="${pageContext.request.contextPath}/mainPage" class="back-button">Back</a>
    </div>
</div>

<div class="footer">
    <jsp:include page="footer.html" />
</div>
</body>
</html>
