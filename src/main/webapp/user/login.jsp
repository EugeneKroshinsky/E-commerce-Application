<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <h1>СКОРО ДОСТУПНО</h1>
    <h1>Вход</h1>
    <form action="${pageContext.request.contextPath}/not_available" method="post">
        <label for="email">Электронная почта:</label><br>
        <input type="email" id="email" name="email" required><br><br>

        <label for="password">Пароль:</label><br>
        <input type="password" id="password" name="password" required><br><br>

        <button type="submit">Войти</button>
    </form>
    <p>Нет аккаунта? <a href="registration.jsp">Зарегистрироваться</a></p>
    <jsp:include page="footer.html" />
</body>
</html>
