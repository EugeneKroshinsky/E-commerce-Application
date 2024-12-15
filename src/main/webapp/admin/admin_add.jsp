<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css">
    <title>Add New User</title>
    <style>
        form {
            max-width: 600px;
            margin: auto;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input, select, button {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="header">
    <jsp:include page="/user/header.jsp" />
</div>

<h1 style="text-align: center;">Add New User</h1>

<form action="${pageContext.request.contextPath}/admin/add" method="POST">
    <label for="firstName">First Name</label>
    <input type="text" id="firstName" name="firstName" required>

    <label for="lastName">Last Name</label>
    <input type="text" id="lastName" name="lastName" required>

    <label for="email">Email</label>
    <input type="email" id="email" name="email" required>

    <label for="password">Password</label>
    <input type="password" id="password" name="password" required>

    <label for="phone">Phone</label>
    <input type="text" id="phone" name="phone">

    <label for="list_roles">Roles</label>
    <select id="list_roles" name="list_roles" multiple>
        <c:forEach var="role" items="${roles}">
            <option value="${role.id}">${role.name}</option>
        </c:forEach>
    </select>

    <button type="submit">Add User</button>
</form>

</body>
</html>
