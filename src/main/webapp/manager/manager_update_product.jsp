<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Edit Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            color: #333;
        }

        h2 {
            font-size: 20px;
            color: #555;
        }

        a {
            text-decoration: none;
            color: inherit;
        }

        input[type="text"], input[type="number"], select {
            width: 30%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        header {
            background-color: #333;
            color: white;
            padding: 20px 0;
            font-family: Arial, sans-serif;
        }

        .header-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 0 20px;
        }

        .logo a {
            font-size: 24px;
            font-weight: bold;
            text-decoration: none;
            color: white;
            text-transform: uppercase;
            letter-spacing: 2px;
        }

        .navigation ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
            display: flex;
        }

        .navigation ul li {
            margin: 0 15px;
        }

        .navigation ul li a {
            text-decoration: none;
            color: white;
            font-size: 18px;
            font-weight: 500;
            text-transform: uppercase;
        }
    </style>
</head>
<body>
<div class="header">
    <jsp:include page="/user/header.jsp" />
</div>

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
    <input type="hidden" id="previousFile" name="previousFile" value="${product.imageUrl}">
    <input type="file" id="fileInput" name="file">
    <br>
    <button type="submit">Update Product</button>
</form>
</body>
</html>
