<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="header">
        <jsp:include page="user/header.jsp" />
    </div>
    <h1> Error ! </h1>
    <p>${error}</p>
    <a href="${pageContext.request.contextPath}/mainPage">To main page</a>

</body>
</html>
