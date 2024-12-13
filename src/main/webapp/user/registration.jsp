<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <jsp:include page="header.jsp" />
  <h1> Скоро доступно </h1>
  <h1>Регистрация</h1>
  <form action="${pageContext.request.contextPath}/not_available" method="post">
    <label for="firstName">Имя:</label><br>
    <input type="text" id="firstName" name="firstName" required><br><br>

    <label for="lastName">Фамилия:</label><br>
    <input type="text" id="lastName" name="lastName" required><br><br>

    <label for="email">Электронная почта:</label><br>
    <input type="email" id="email" name="email" required><br><br>

    <label for="phone">Номер телефона:</label><br>
    <input type="tel" id="phone" name="phone" required><br><br>

    <label for="password">Пароль:</label><br>
    <input type="password" id="password" name="password" required><br><br>

    <label for="password">Подтвердите пароль:</label><br>
    <input type="password" id="passwordCheck" name="passwordCheck" required><br><br>


    <button type="submit">Зарегистрироваться</button>
  </form>
  <p>Уже есть аккаунт? <a href="login.jsp">Войти</a></p>
  <jsp:include page="footer.html" />
</body>
</html>
