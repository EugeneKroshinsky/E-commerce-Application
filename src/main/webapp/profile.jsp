<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
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
            width: 100%;
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

        footer {
            background-color: #333;
            color: white;
            padding: 40px 20px;
            font-family: Arial, sans-serif;
        }

        .footer-container {
            max-width: 1200px;
            margin: 0 auto;
            display: flex;
            justify-content: center;
        }

        .footer-info {
            text-align: left;
        }

        .footer-title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 15px;
            text-transform: uppercase;
            letter-spacing: 2px;
        }

        .footer-info p {
            font-size: 16px;
            margin-bottom: 10px;
        }

        .footer-info p strong {
            font-weight: bold;
        }

        /* style_profile.css */
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            color: #333;
            text-align: center;
        }

        h1 {
            font-size: 32px;
            margin-top: 20px;
            color: #4CAF50;
        }

        p {
            font-size: 18px;
            margin: 10px 0;
            line-height: 1.5;
        }

        p strong {
            color: #555;
        }

        .roles ul {
            list-style-type: none;
            padding: 0;
            margin: 20px 0;
        }

        .roles ul li {
            font-size: 18px;
            color: #333;
            margin: 5px 0;
        }

        .manager-link {
            margin-top: 20px;
        }

        .manager-link a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007BFF;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
            text-transform: uppercase;
        }

        .manager-link a:hover {
            background-color: #0056b3;
        }

        .header, .footer {
            background-color: #333;
            color: white;
            padding: 10px 0;
            text-align: center;
        }

        .header {
            margin-bottom: 20px;
        }

        .footer {
            margin-top: 40px;
            font-size: 14px;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background: white;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        .container h1 {
            margin-top: 0;
        }

    </style>
</head>
<body>
<div class="header">
    <jsp:include page="user/header.jsp" />
</div>
    <h1>User Profile</h1>
    <p><strong>First Name:</strong> ${user.firstName}</p>
    <p><strong>Last Name:</strong> ${user.lastName}</p>
    <p><strong>Email:</strong> ${user.email}</p>
    <p><strong>Phone:</strong> ${user.phone}</p>

    <div class="roles">
        <p><strong>Roles:</strong></p>
        <ul>
            <c:forEach var="role" items="${user.roles}">
                <li>${role.name}</li>
            </c:forEach>
        </ul>
    </div>

    <div class="logout-button">
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </div>

<c:if test="${user.roles.stream()
                .map(el -> el.getName())
                .toList()
                .contains('MANGER')}">
        <div class="manager-link">
            <a href="${pageContext.request.contextPath}/manager">Manage products and orders</a>
        </div>
    </c:if>
    <c:if test="${user.roles.stream()
                .map(el -> el.getName())
                .toList()
                .contains('ADMIN')}">
        <div class="manager-link">
            <a href="${pageContext.request.contextPath}/admin">Manage users</a>
        </div>
    </c:if>

<div class="footer">
    <jsp:include page="user/footer.html" />
</div>
</body>
</html>
