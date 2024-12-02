<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/order" method="post">
    <label for="firstName">First Name</label>
    <input type="text" id="firstName" name="firstName" required>
    <br>
    <label for="lastName">Last Name</label>
    <input type="text" id="lastName" name="lastName" required>
    <br>
    <label for="email">Email</label>
    <input type="email" id="email" name="email" required>
    <br>
    <label for="phone">Phone Number</label>
    <input type="tel" id="phone" name="phone" placeholder="+375 xx xxx xx xx" required>
    <br>
    <label for="address">Delivery Address</label>
    <input type="text" id="address" name="address" placeholder="City, Street st., xxx, xxx" required>
    <br>
    <label for="comment">Comment</label>
    <textarea id="comment" name="comment" rows="4" placeholder="Optional"></textarea>
    <br>
    <button type="submit">Place Order</button>
</form>
</body>
</html>
