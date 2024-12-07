<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<a href="javascript:history.back()">Back</a>
<h1>Edit Product</h1>

<form action="${pageContext.request.contextPath}/admin/update/productEntity" method="post">
    <input type="hidden" name="id" value="${productEntity.id}">

    <label for="name">Product Name:</label>
    <input type="text" id="name" name="name" value="${productEntity.name}" required>
    <br><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" rows="4" required>${productEntity.description}</textarea>
    <br><br>

    <label for="price">Price:</label>
    <input type="number" id="price" name="price" step="0.01" min="0" value="${productEntity.price}" required>
    <br><br>

    <label for="quantity">Quantity:</label>
    <input type="number" id="quantity" name="quantity" min="0" value="${productEntity.quantity}" required>
    <br><br>

    <label for="categoryEntity">Category:</label>
    <select id="categoryEntity" name="categoryId" required>
        <option value="">-- Select a Category --</option>
        <c:forEach var="categoryEntity" items="${categories}">
            <option value="${categoryEntity.id}"
                    <c:if test="${categoryEntity.id == productEntity.categoryEntity.id}">selected</c:if>>
                    ${categoryEntity.name}
            </option>
        </c:forEach>
    </select>
    <br><br>

    <button type="submit">Update Product</button>
</form>
</body>
</html>
