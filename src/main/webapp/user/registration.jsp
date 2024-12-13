<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Registration</title>
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/style_registration.css">
</head>
<body>

<jsp:include page="header.jsp" />

<div class="registration-container">
  <h1 class="page-title">TEMPORARILY UNAVAILABLE</h1>
  <h2 class="registration-heading">Registration</h2>

  <form action="${pageContext.request.contextPath}/not_available" method="post" class="registration-form">
    <div class="form-group">
      <label for="firstName">First Name:</label>
      <input type="text" id="firstName" name="firstName" required placeholder="Enter your first name">
    </div>

    <div class="form-group">
      <label for="lastName">Last Name:</label>
      <input type="text" id="lastName" name="lastName" required placeholder="Enter your last name">
    </div>

    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" id="email" name="email" required placeholder="Enter your email">
    </div>

    <div class="form-group">
      <label for="phone">Phone Number:</label>
      <input type="tel" id="phone" name="phone" required placeholder="Enter your phone number">
    </div>

    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required placeholder="Enter your password">
    </div>

    <div class="form-group">
      <label for="passwordCheck">Confirm Password:</label>
      <input type="password" id="passwordCheck" name="passwordCheck" required placeholder="Confirm your password">
    </div>

    <div class="form-actions">
      <button type="submit" class="register-button">Register</button>
    </div>
  </form>

  <p class="login-link">Already have an account? <a href="login.jsp">Login</a></p>
</div>

<jsp:include page="footer.html" />

</body>
</html>
``
