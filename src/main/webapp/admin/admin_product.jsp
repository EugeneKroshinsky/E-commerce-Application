<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Admin - Products</title>
</head>
<body>
<a href="javascript:history.back()">Back</a>
<h1>Product Management</h1>

<a href="${pageContext.request.contextPath}/admin/add/product">Create New Product</a>

<table border="1" cellpadding="10" cellspacing="0">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Category</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.category.name}</td>
            <td>
                <form action="${pageContext.request.contextPath}/admin/product" method="POST" style="display: inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${product.id}">
                    <button type="submit">Delete</button>
                </form>
                <form action="${pageContext.request.contextPath}/admin/update/product/${product.id}" method="GET" style="display: inline;">
                    <button type="submit">Edit</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
