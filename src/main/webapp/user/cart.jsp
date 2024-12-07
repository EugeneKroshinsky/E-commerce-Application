<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="header.jsp" />
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
        <form action="${pageContext.request.contextPath}/cart" method="POST">
            <input type="hidden" name="action" value="delete">
            <input type="hidden" name="productId" value="${item.product.id}">
            <button type="submit">Delete</button>
        </form>
        <hr>
    </c:forEach>

    <p><b>Total: </b>${cart.stream().map(ct -> ct.product.price * ct.quantity).sum()}</p>
    <a href="${pageContext.request.contextPath}/order">Order</a>
    <br>
    <a href="${pageContext.request.contextPath}/mainPage">Back</a>
    <jsp:include page="footer.html" />
</body>
</html>
