<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>All Orders</title>
</head>
<body>
<a href="javascript:history.back()">Back</a>
<h1>All Orders</h1>

<table border="1" cellpadding="10">
    <thead>
    <tr>
        <th>ID</th>
        <th>Customer Name</th>
        <th>Customer Surname</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Total Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.id}</td>
            <td>${order.firstName}</td>
            <td>${order.lastName}</td>
            <td>${order.email}</td>
            <td>${order.phone}</td>
            <td>${order.address}</td>
            <td>${order.totalPrice}</td>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
