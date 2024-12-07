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
<p><b>Order ID:</b> ${orderEntity.id}</p>
<p><b>Name:</b> ${orderEntity.firstName} ${orderEntity.lastName}</p>
<p><b>Email:</b> ${orderEntity.email}</p>
<p><b>Phone:</b> ${orderEntity.phone}</p>
<p><b>Address:</b> ${orderEntity.address}</p>
<p><b>Comment:</b> ${orderEntity.comment}</p>

<h2>Order Items:</h2>
    <c:forEach var="item" items="${orderEntity.items}">
        <hr>
        <p><b>Name: </b>${item.productEntity.name}</p>
        <p><b>Description: </b>${item.productEntity.description}</p>
        <p><b>Price: </b>${item.productEntity.price}</p>
        <p><b>Quantity: </b>${item.quantity}</p>
        <p><b>Total price: </b>${item.quantity * item.productEntity.price}</p>
        <hr>
    </c:forEach>

<p><b>Total Price:</b> ${orderEntity.items.stream().map(item -> item.productEntity.price * item.quantity).sum()}</p>
<a href="${pageContext.request.contextPath}/mainPage">Return to Product List</a>
<jsp:include page="footer.html" />
</body>
</html>
