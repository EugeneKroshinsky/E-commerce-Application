<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
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
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .login-container {
            width: 80%;
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .page-title {
            text-align: center;
            font-size: 24px;
            color: #ff0000;
            margin-bottom: 20px;
        }

        .login-heading {
            text-align: center;
            font-size: 20px;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            font-size: 16px;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-group input:focus {
            border-color: #4CAF50;
            outline: none;
        }

        .form-actions {
            text-align: center;
        }

        .login-button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        .login-button:hover {
            background-color: #45a049;
        }

        .register-link {
            text-align: center;
            margin-top: 15px;
            font-size: 16px;
        }

        .register-link a {
            color: #007BFF;
            text-decoration: none;
        }

        .register-link a:hover {
            text-decoration: underline;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp" />

<div class="login-container">
    <h2 class="login-heading">Login</h2>

    <div class="error">
        <c:if test="${error != null && !error.isEmpty()}">
            <p>Wrong email or password</p>
        </c:if>
    </div>
    <form action="${pageContext.request.contextPath}/login" method="post" class="login-form">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required placeholder="Enter your email">
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required placeholder="Enter your password">
        </div>

        <div class="form-actions">
            <button type="submit" class="login-button">Login</button>
        </div>
    </form>

    <p class="register-link">Don't have an account? <a href="${pageContext.request.contextPath}/registration">Register</a></p>
</div>
<div class="footer">
    <jsp:include page="footer.html" />
</div>
</body>
</html>
