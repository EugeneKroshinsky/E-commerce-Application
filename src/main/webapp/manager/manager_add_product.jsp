<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Create New Product</title>
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
<h1>Create New Product</h1>

<form action="${pageContext.request.contextPath}/manager/add/product" method="post" enctype="multipart/form-data" >
    <label for="name">Product Name:</label>
    <input type="text" id="name" name="name" required>
    <br><br>

    <label for="producer">Producer:</label>
    <input type="text" id="producer" name="producer" required>
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
    <select id="category" name="categoryId" required>
        <option value="">-- Select a Category --</option>
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <br>
   <label for="fileInput">Загрузите файл:</label>
   <input type="file" id="fileInput" name="file">
    <br>
    <button type="submit">Create Product</button>
</form>
</body>
</html>
