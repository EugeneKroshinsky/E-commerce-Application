<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>All Orders</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f4f4f4;
            text-align: left;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
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
        <th>Date</th>
        <th>Total Price</th>
        <th>Order Items</th>
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
            <td>${order.createdAt}</td>
            <td>${order.orderItems.stream().map(item -> item.product.price * item.quantity).sum()}</td>
            <td>
                <table border="1" cellpadding="5">
                    <thead>
                    <tr>
                        <th>Product Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${order.orderItems}">
                        <tr>
                            <td>${item.product.name}</td>
                            <td>${item.product.description}</td>
                            <td>${item.product.price}</td>
                            <td>${item.quantity}</td>
                            <td>${item.product.price * item.quantity}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
