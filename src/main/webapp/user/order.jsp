<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Form</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/style_order.css">
</head>
<body>

<jsp:include page="header.jsp" />

<div class="order-container">
    <c:if test="${cart.isEmpty()}">
        <p class="cart-empty-message">Your cart is empty</p>
    </c:if>

    <c:if test="${!cart.isEmpty()}">
        <h2>Place Your Order</h2>
        <form action="${pageContext.request.contextPath}/order" method="post" class="order-form">
            <div class="form-group">
                <label for="firstName">First Name</label>
                <input type="text" id="firstName" name="firstName" required>
            </div>

            <div class="form-group">
                <label for="lastName">Last Name</label>
                <input type="text" id="lastName" name="lastName" required>
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>

            <div class="form-group">
                <label for="phone">Phone Number</label>
                <input type="tel" id="phone" name="phone" placeholder="+375 xx xxx xx xx" required>
            </div>

            <div class="form-group">
                <label for="address">Delivery Address</label>
                <input type="text" id="address" name="address" placeholder="City, Street st., xxx, xxx" required>
            </div>

            <div class="form-group">
                <label for="comment">Comment (Optional)</label>
                <textarea id="comment" name="comment" rows="4" placeholder="Any special instructions or comments"></textarea>
            </div>

            <div class="form-actions">
                <button type="submit" class="submit-button">Place Order</button>
            </div>
        </form>
    </c:if>
</div>

<div class="footer">
    <jsp:include page="footer.html" />
</div>

</body>
</html>
