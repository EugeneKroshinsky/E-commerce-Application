<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Success</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/style_success_order.css">
</head>
<body>

<jsp:include page="header.jsp" />

<div class="order-success-container">
    <h1>Order Successfully Placed!</h1>

    <div class="order-details">
        <h2>Personal Information:</h2>
        <p><strong>Name:</strong> ${order.firstName} ${order.lastName}</p>
        <p><strong>Email:</strong> ${order.email}</p>
        <p><strong>Phone:</strong> ${order.phone}</p>
        <p><strong>Address:</strong> ${order.address}</p>
        <p><strong>Comment:</strong> ${order.comment}</p>
    </div>

    <div class="order-items">
        <h2>Order Items:</h2>
        <c:forEach var="item" items="${order.orderItems}">
            <div class="order-item">
                <hr>
                <p><strong>Product Name:</strong> ${item.product.name}</p>
                <p><strong>Description:</strong> ${item.product.description}</p>
                <p><strong>Price:</strong> ${item.product.price}</p>
                <p><strong>Quantity:</strong> ${item.quantity}</p>
                <p><strong>Total Price:</strong> ${item.quantity * item.product.price}</p>
                <hr>
            </div>
        </c:forEach>

        <div class="order-total">
            <p><strong>Total Price:</strong>
                ${order.orderItems.stream().map(item -> item.product.price * item.quantity).sum()}
            </p>
        </div>
    </div>

    <div class="return-link">
        <a href="${pageContext.request.contextPath}/mainPage">Return to Product List</a>
    </div>
</div>

<div class="footer">
    <jsp:include page="footer.html" />
</div>

</body>
</html>
