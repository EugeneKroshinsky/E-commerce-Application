<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Create New Product</title>
</head>
<body>
<a href="javascript:history.back()">Back</a>
<h1>Create New Product</h1>

<form action="${pageContext.request.contextPath}/admin/add/product" method="post" >
    <label for="name">Product Name:</label>
    <input type="text" id="name" name="name" required>
    <br><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" rows="4" required></textarea>
    <br><br>

    <label for="price">Price:</label>
    <input type="number" id="price" name="price" step="0.01" min="0" required>
    <br><br>

    <label for="quantity">Quantity:</label>
    <input type="number" id="quantity" name="quantity" min="0" required>
    <br><br>

    <label for="category">Category:</label>
    <select id="category" name="categoryId">
        <option value="">-- Select a Category --</option>
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <br><br>



    <button type="submit">Create Product</button>
</form>
</body>
</html>
