<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>All Orders</title>
</head>
<body>
<a href="javascript:history.back()">Back</a>
<h1>All Orders</h1>

<table border="1" cellpadding="10">
    <thead>
    <tr>
        <th>ID</th>
        <th>Customer Name</th>
        <th>Customer Surname</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Total Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="orderEntity" items="${orderEntities}">
        <tr>
            <td>${orderEntity.id}</td>
            <td>${orderEntity.firstName}</td>
            <td>${orderEntity.lastName}</td>
            <td>${orderEntity.email}</td>
            <td>${orderEntity.phone}</td>
            <td>${orderEntity.address}</td>
            <td>${orderEntity.totalPrice}</td>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
