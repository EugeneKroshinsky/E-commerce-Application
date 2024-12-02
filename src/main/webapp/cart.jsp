<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Cart</h1>
    <c:if test="${cart.isEmpty()}">
        <p>Cart is empty</p>
    </c:if>
    <c:forEach var="item" items="${cart}">
        <hr>
        <p><b>Name: </b>${item.product.name}</p>
        <p><b>Description: </b>${item.product.description}</p>
        <p><b>Price: </b>${item.product.price}</p>
        <p><b>Quantity: </b>${item.quantity}</p>
        <p><b>Total price: </b>${item.quantity * item.product.price}</p>
        <hr>
        <form action="${pageContext.request.contextPath}/cart" method="POST">
            <input type="hidden" name="action" value="delete">
            <input type="hidden" name="productId" value="${item.product.id}">
            <label>Quantity:</label>
            <button type="submit">Delete</button>
        </form>
    </c:forEach>

    <p><b>Total: </b>${cart.stream().map(ct -> ct.product.price * ct    .quantity).sum()}</p>
    <a href="${pageContext.request.contextPath}/order">Order</a>
    <br>
    <a href="${pageContext.request.contextPath}/mainPage">Back</a>
</body>
</html>
