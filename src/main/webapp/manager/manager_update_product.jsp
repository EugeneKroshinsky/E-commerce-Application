<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<a href="javascript:history.back()">Back</a>
<h1>Edit Product</h1>

<form action="${pageContext.request.contextPath}/manager/update/product" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${product.id}">

    <label for="name">Product Name:</label>
    <input type="text" id="name" name="name" value="${product.name}" required>
    <br><br>

    <label for="producer">Producer:</label>
    <input type="text" id="producer" name="producer" value="${product.producer}" required>
    <br><br>


    <label for="description">Description:</label>
    <textarea id="description" name="description" rows="4" required>${product.description}</textarea>
    <br><br>

    <label for="price">Price:</label>
    <input type="number" id="price" name="price" step="0.01" min="0" value="${product.price}" required>
    <br><br>

    <label for="quantity">Quantity:</label>
    <input type="number" id="quantity" name="quantity" min="0" value="${product.quantity}" required>
    <br><br>

    <label for="categoryEntity">Category:</label>
    <select id="categoryEntity" name="categoryId" required>
        <option value="">-- Select a Category --</option>
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}"
                    <c:if test="${category.id == product.category.id}">selected</c:if>>
                    ${category.name}
            </option>
        </c:forEach>
    </select>
    <br><br>

    <label for="fileInput">Загрузите файл:</label>
    <input type="file" id="fileInput" name="file">
    <br>
    <button type="submit">Update Product</button>
</form>
</body>
</html>
