<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Order Success</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>Order Successfully Placed!</h1>
<h2>Person information:</h2>
<p><b>Order ID:</b> ${order.id}</p>
<p><b>Name:</b> ${order.firstName} ${order.lastName}</p>
<p><b>Email:</b> ${order.email}</p>
<p><b>Phone:</b> ${order.phone}</p>
<p><b>Address:</b> ${order.address}</p>
<p><b>Comment:</b> ${order.comment}</p>

<h2>Order Items:</h2>
    <c:forEach var="item" items="${order.orderItems}">
        <hr>
        <p><b>Name: </b>${item.product.name}</p>
        <p><b>Description: </b>${item.product.description}</p>
        <p><b>Price: </b>${item.product.price}</p>
        <p><b>Quantity: </b>${item.quantity}</p>
        <p><b>Total price: </b>${item.quantity * item.product.price}</p>
        <hr>
    </c:forEach>

<p><b>Total Price:</b> ${order.orderItems.stream().map(item -> item.product.price * item.quantity).sum()}</p>
<br>
<a href="${pageContext.request.contextPath}/mainPage">Return to Product List</a>
<jsp:include page="footer.html" />
</body>
</html>
