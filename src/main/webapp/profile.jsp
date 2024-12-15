<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/style_profile.css">
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
                <li>${role}</li>
            </c:forEach>
        </ul>
    </div>

    <c:if test="${user.roles.contains('ADMIN')}">
        <div class="admin-link">
            <a href="${pageContext.request.contextPath}/admin">Manage</a>
        </div>
    </c:if>

<div class="footer">
    <jsp:include page="user/footer.html" />
</div>
</body>
</html>
