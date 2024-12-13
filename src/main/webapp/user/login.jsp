<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/style_login.css">
</head>
<body>

<jsp:include page="header.jsp" />

<div class="login-container">
    <h1 class="page-title">TEMPORARILY UNAVAILABLE</h1>
    <h2 class="login-heading">Login</h2>

    <form action="${pageContext.request.contextPath}/not_available" method="post" class="login-form">
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

    <p class="register-link">Don't have an account? <a href="registration.jsp">Register</a></p>
</div>

<jsp:include page="footer.html" />

</body>
</html>
