<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Users Table</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f4f4f4;
            text-align: left;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>

<h1>Users List</h1>

<a href="${pageContext.request.contextPath}/admin/add">Create New Admin</a>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Roles</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
            <td><c:forEach var="role" items="${user.roles}">
                ${role.name}
            </c:forEach></td>
            <td>
<%--                <a href="${pageContext.request.contextPath}/manager/delete/user/${user.id}">Edit</a>--%>
<%--                <a href="${pageContext.request.contextPath}/manager/update/user/${user.id}">Edit</a>--%>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${empty users}">
        <tr>
            <td colspan="7" style="text-align: center;">No users found</td>
        </tr>
    </c:if>
    </tbody>
</table>

</body>
</html>
